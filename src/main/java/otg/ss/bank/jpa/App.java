package otg.ss.bank.jpa;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import otg.ss.bank.jpa.domain.Address;
import otg.ss.bank.jpa.domain.Agency;
import otg.ss.bank.jpa.domain.ChargedAccount;
import otg.ss.bank.jpa.domain.SavingAccount;
import otg.ss.bank.jpa.domain.SimpleAccount;
import otg.ss.bank.jpa.domain.Transaction;
import otg.ss.bank.jpa.domain.Transaction.Type;
import otg.ss.bank.jpa.domain.TransactionId;

public class App {

	public static void main(String... args) {

		EntityManagerFactory emf = null;
		EntityManager em = null;

		try {
			emf = Persistence.createEntityManagerFactory("tp-jpa-ss");
			em = emf.createEntityManager();

			Agency agency = new Agency();
			Address address = new Address("2bis", "rue Victor Hugo", "56000", "Longbourg");
			ChargedAccount chargedAccount = new ChargedAccount(53, 23);
			chargedAccount.setAgency(agency);
			SavingAccount savingAccount = new SavingAccount(45009, 4);
			savingAccount.setAgency(agency);
			SimpleAccount simpleAccount = new SimpleAccount(4324, 34);
			simpleAccount.setAgency(agency);
			Transaction transaction = new Transaction();
			transaction.setAgency(agency);
			transaction.setAccount(savingAccount);
			TransactionId transactionId = new TransactionId();
			transactionId.setAccountId(1L);
			transactionId.setAgencyId(1L);
			transactionId.setDate(new Date());
			transaction.setId(transactionId);
			transaction.setAmount(23);
			transaction.setBalanceBefore(43);
			transaction.setBalanceBefore(22);
			transaction.setType(Type.IPM);

			agency.setCode("45a");
			agency.setAddress(address);

			em.getTransaction().begin();
			em.persist(agency);

			// Extraction des informations liées à cette entité (sélection);

			// n°1
			Agency agency1 = em.find(Agency.class, 1l);
			if (agency1 != null) {
				System.out.println(agency1);
			}

			// n°2
			TypedQuery<Agency> query = em.createQuery("SELECT A FROM Agency A", Agency.class);
			if (query.getResultList().get(0) != null) {
				Agency agency2 = query.getResultList().get(0);
				System.out.println(agency2);
			}

			// Modifications (création, modification et suppression)

			// création
			Agency agency2 = new Agency();
			agency2.setCode("blabla");
			agency2.setAddress(address);
			em.persist(agency2);

			em.getTransaction().commit();

			em.getTransaction().begin();

			// modification
			Agency agency3 = em.find(Agency.class, 1l);
			if (agency3 != null) {
				agency3.setCode("nouveauCode");
			}

			// suppression
			Agency agency4 = em.find(Agency.class, 2l);
			if (agency4 != null) {
				em.remove(agency2);
			}

			em.getTransaction().commit();

		} finally {
			if (em != null) {
				em.close();
			}
			if (emf != null) {
				emf.close();
			}
		}

	}
}
