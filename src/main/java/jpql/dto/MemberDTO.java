package jpql.dto;

/**
 * Created by parkey19 on 2020/01/30.
 */

public class MemberDTO {

    public Long id;
    public String username;
    public String teamName;

    public MemberDTO(Long id, String username, String teamName) {
        this.id = id;
        this.username = username;
        this.teamName = teamName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", teamName='" + teamName + '\'' +
                '}';
    }
}
