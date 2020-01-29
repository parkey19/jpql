import jpql.Member;
import jpql.Team;
import jpql.dto.MemberDTO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;


public class JPAMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpashop");
        EntityManager em = emf.createEntityManager();
        EntityTransaction ts = em.getTransaction();
        ts.begin();

        try {
            Team team = new Team();
            team.setName("a team");

            em.persist(team);

            Member member = new Member();
            member.setUserName("park");
            member.setAge(35);
            member.setTeam(team);
            em.persist(member);

            Member member2 = new Member();
            member2.setUserName("kim");
            member2.setAge(30);
            member2.setTeam(team);
            em.persist(member2);

            em.flush();
            em.clear();

            List<Object[]> resultList = em.createQuery("select m,t from Member m left join m.team t on t.name = 'a team'")
                    .getResultList();

            Object[] objects = resultList.get(0);
            System.out.println(objects[0]);
            System.out.println(objects[1]);

            Object[] objects2 = resultList.get(1);

            System.out.println(objects2[0]);
            System.out.println(objects2[1]);

            List<MemberDTO> resultList2 = em.createQuery("select new jpql.dto.MemberDTO(m.id, m.username, t.name) from Member m left join m.team t on t.name = 'a team'", MemberDTO.class)
                    .getResultList();

            resultList2.stream().forEach(System.out::println);


            ts.commit();
        } catch (Exception e) {
            ts.rollback();
        } finally {
            em.close();
        }

    }
}
