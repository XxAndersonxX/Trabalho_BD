package Trabalho_BD.entities;

public class MetasEstudo {
    private Integer horaMeta;
    private String metasEstudo;

    public MetasEstudo(){
    }

    public MetasEstudo(Integer horaMeta, String metasEstudo) {
        this.horaMeta = horaMeta;
        this.metasEstudo = metasEstudo;
    }

    public Integer getHoraMeta() {
        return horaMeta;
    }

    public void setHoraMeta(Integer horaMeta) {
        this.horaMeta = horaMeta;
    }

    public String getMetasEstudo() {
        return metasEstudo;
    }

    public void setMetasEstudo(String metasEstudo) {
        this.metasEstudo = metasEstudo;
    }

    @Override
    public String toString() {
        return "MetasEstudo [horaMeta=" + horaMeta + ", metasEstudo=" + metasEstudo + "]";
    }
}