package messageCreator.IOCreateCampaign.jsonPojo;

import java.util.List;
import java.util.Objects;

public class Schema {
    private Integer id;
    private String comments;
    private String action;
    private Integer record_id;
    private Integer dtmf;
    private String result;
    private Integer group_id;
    private Integer member_id;
    private Integer item_id;
    private List<Schema> subitems;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Integer getRecord_id() {
        return record_id;
    }

    public void setRecord_id(Integer record_id) {
        this.record_id = record_id;
    }

    public Integer getDtmf() {
        return dtmf;
    }

    public void setDtmf(Integer dtmf) {
        this.dtmf = dtmf;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Integer getGroup_id() {
        return group_id;
    }

    public void setGroup_id(Integer group_id) {
        this.group_id = group_id;
    }

    public Integer getMember_id() {
        return member_id;
    }

    public void setMember_id(Integer member_id) {
        this.member_id = member_id;
    }

    public Integer getItem_id() {
        return item_id;
    }

    public void setItem_id(Integer item_id) {
        this.item_id = item_id;
    }

    public List<Schema> getSubitems() {
        return subitems;
    }

    public void setSubitems(List<Schema> subitems) {
        this.subitems = subitems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schema schema = (Schema) o;
        return Objects.equals(id, schema.id) &&
                Objects.equals(comments, schema.comments) &&
                Objects.equals(action, schema.action) &&
                Objects.equals(record_id, schema.record_id) &&
                Objects.equals(dtmf, schema.dtmf) &&
                Objects.equals(result, schema.result) &&
                Objects.equals(group_id, schema.group_id) &&
                Objects.equals(member_id, schema.member_id) &&
                Objects.equals(item_id, schema.item_id) &&
                Objects.equals(subitems, schema.subitems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, comments, action, record_id, dtmf, result, group_id, member_id, item_id, subitems);
    }

    @Override
    public String toString() {
        return "Schema{" +
                "id=" + id +
                ", comments='" + comments + '\'' +
                ", action='" + action + '\'' +
                ", record_id=" + record_id +
                ", dtmf=" + dtmf +
                ", result='" + result + '\'' +
                ", group_id=" + group_id +
                ", member_id=" + member_id +
                ", item_id=" + item_id +
                ", subitems=" + subitems +
                '}';
    }
}
