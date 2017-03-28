/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MFFRest;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Richard's Surface
 */
@Entity
@Table(name = "STUDENT_FRIEND_RELATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudentFriendRelation.findAll", query = "SELECT s FROM StudentFriendRelation s")
    , @NamedQuery(name = "StudentFriendRelation.findByFriendshipid", query = "SELECT s FROM StudentFriendRelation s WHERE s.friendshipid = :friendshipid")
    , @NamedQuery(name = "StudentFriendRelation.findByStartingDate", query = "SELECT s FROM StudentFriendRelation s WHERE s.startingDate = :startingDate")
    , @NamedQuery(name = "StudentFriendRelation.findByEndingDate", query = "SELECT s FROM StudentFriendRelation s WHERE s.endingDate = :endingDate")
//    , @NamedQuery(name = "Student.findByAnyAtLeastTwoAttributeInTwoTables2", query = "SELECT s FROM StudentFriendRelation sfr JOIN Student s WHERE s.:columnName1 = :attribute1 AND sfr.:columnName2 = :attribute2")
})
public class StudentFriendRelation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "FRIENDSHIPID")
    private Integer friendshipid;
    @Size(max = 10)
    @Column(name = "STARTING_DATE")
    private String startingDate;
    @Size(max = 10)
    @Column(name = "ENDING_DATE")
    private String endingDate;
    @JoinColumn(name = "HAS_FRIEND", referencedColumnName = "SID")
    @ManyToOne
    private Student hasFriend;
    @JoinColumn(name = "SID", referencedColumnName = "SID")
    @ManyToOne
    private Student sid;

    public StudentFriendRelation() {
    }

    public StudentFriendRelation(Integer friendshipid) {
        this.friendshipid = friendshipid;
    }

    public Integer getFriendshipid() {
        return friendshipid;
    }

    public void setFriendshipid(Integer friendshipid) {
        this.friendshipid = friendshipid;
    }

    public String getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(String startingDate) {
        this.startingDate = startingDate;
    }

    public String getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(String endingDate) {
        this.endingDate = endingDate;
    }

    public Student getHasFriend() {
        return hasFriend;
    }

    public void setHasFriend(Student hasFriend) {
        this.hasFriend = hasFriend;
    }

    public Student getSid() {
        return sid;
    }

    public void setSid(Student sid) {
        this.sid = sid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (friendshipid != null ? friendshipid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentFriendRelation)) {
            return false;
        }
        StudentFriendRelation other = (StudentFriendRelation) object;
        if ((this.friendshipid == null && other.friendshipid != null) || (this.friendshipid != null && !this.friendshipid.equals(other.friendshipid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MFFRest.StudentFriendRelation[ friendshipid=" + friendshipid + " ]";
    }
    
}
