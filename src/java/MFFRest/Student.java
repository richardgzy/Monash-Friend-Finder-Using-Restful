/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MFFRest;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Richard's Surface
 */
@Entity
@Table(name = "STUDENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s")
    , @NamedQuery(name = "Student.findBySid", query = "SELECT s FROM Student s WHERE s.sid = :sid")
    , @NamedQuery(name = "Student.findByFName", query = "SELECT s FROM Student s WHERE s.fName = :fName")
    , @NamedQuery(name = "Student.findByLName", query = "SELECT s FROM Student s WHERE s.lName = :lName")
    , @NamedQuery(name = "Student.findByDob", query = "SELECT s FROM Student s WHERE s.dob = :dob")
    , @NamedQuery(name = "Student.findByGender", query = "SELECT s FROM Student s WHERE s.gender = :gender")
    , @NamedQuery(name = "Student.findByStudyMode", query = "SELECT s FROM Student s WHERE s.studyMode = :studyMode")
    , @NamedQuery(name = "Student.findByCourse", query = "SELECT s FROM Student s WHERE s.course = :course")
    , @NamedQuery(name = "Student.findByAddress", query = "SELECT s FROM Student s WHERE s.address = :address")
    , @NamedQuery(name = "Student.findBySubrub", query = "SELECT s FROM Student s WHERE s.subrub = :subrub")
    , @NamedQuery(name = "Student.findByNationality", query = "SELECT s FROM Student s WHERE s.nationality = :nationality")
    , @NamedQuery(name = "Student.findByNativeLanguage", query = "SELECT s FROM Student s WHERE s.nativeLanguage = :nativeLanguage")
    , @NamedQuery(name = "Student.findByFavouriteSport", query = "SELECT s FROM Student s WHERE s.favouriteSport = :favouriteSport")
    , @NamedQuery(name = "Student.findByFavouriteMovie", query = "SELECT s FROM Student s WHERE s.favouriteMovie = :favouriteMovie")
    , @NamedQuery(name = "Student.findByFavouriteUnit", query = "SELECT s FROM Student s WHERE s.favouriteUnit = :favouriteUnit")
    , @NamedQuery(name = "Student.findByCurrentJob", query = "SELECT s FROM Student s WHERE s.currentJob = :currentJob")
    , @NamedQuery(name = "Student.findByMonashEmail", query = "SELECT s FROM Student s WHERE s.monashEmail = :monashEmail")
    , @NamedQuery(name = "Student.findByPassword", query = "SELECT s FROM Student s WHERE s.password = :password")
    , @NamedQuery(name = "Student.findBySubscriptionDate", query = "SELECT s FROM Student s WHERE s.subscriptionDate = :subscriptionDate")
    , @NamedQuery(name = "Student.findBySubscriptionTime", query = "SELECT s FROM Student s WHERE s.subscriptionTime = :subscriptionTime")
    })
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SID")
    private Integer sid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "F_NAME")
    private String fName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "L_NAME")
    private String lName;
    @Size(max = 10)
    @Column(name = "DOB")
    private String dob;
    @Size(max = 10)
    @Column(name = "GENDER")
    private String gender;
    @Size(max = 10)
    @Column(name = "STUDY_MODE")
    private String studyMode;
    @Size(max = 10)
    @Column(name = "COURSE")
    private String course;
    @Size(max = 100)
    @Column(name = "ADDRESS")
    private String address;
    @Size(max = 50)
    @Column(name = "SUBRUB")
    private String subrub;
    @Size(max = 100)
    @Column(name = "NATIONALITY")
    private String nationality;
    @Size(max = 30)
    @Column(name = "NATIVE_LANGUAGE")
    private String nativeLanguage;
    @Size(max = 50)
    @Column(name = "FAVOURITE_SPORT")
    private String favouriteSport;
    @Size(max = 50)
    @Column(name = "FAVOURITE_MOVIE")
    private String favouriteMovie;
    @Size(max = 8)
    @Column(name = "FAVOURITE_UNIT")
    private String favouriteUnit;
    @Size(max = 50)
    @Column(name = "CURRENT_JOB")
    private String currentJob;
    @Size(max = 50)
    @Column(name = "MONASH_EMAIL")
    private String monashEmail;
    @Size(max = 20)
    @Column(name = "PASSWORD")
    private String password;
    @Size(max = 10)
    @Column(name = "SUBSCRIPTION_DATE")
    private String subscriptionDate;
    @Size(max = 8)
    @Column(name = "SUBSCRIPTION_TIME")
    private String subscriptionTime;
    @OneToMany(mappedBy = "sid")
    private Collection<StudentLocation> studentLocationCollection;
    @OneToMany(mappedBy = "hasFriend")
    private Collection<StudentFriendRelation> studentFriendRelationCollection;
    @OneToMany(mappedBy = "sid")
    private Collection<StudentFriendRelation> studentFriendRelationCollection1;

    public Student() {
    }

    public Student(Integer sid) {
        this.sid = sid;
    }

    public Student(Integer sid, String fName, String lName) {
        this.sid = sid;
        this.fName = fName;
        this.lName = lName;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getLName() {
        return lName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStudyMode() {
        return studyMode;
    }

    public void setStudyMode(String studyMode) {
        this.studyMode = studyMode;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSubrub() {
        return subrub;
    }

    public void setSubrub(String subrub) {
        this.subrub = subrub;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getNativeLanguage() {
        return nativeLanguage;
    }

    public void setNativeLanguage(String nativeLanguage) {
        this.nativeLanguage = nativeLanguage;
    }

    public String getFavouriteSport() {
        return favouriteSport;
    }

    public void setFavouriteSport(String favouriteSport) {
        this.favouriteSport = favouriteSport;
    }

    public String getFavouriteMovie() {
        return favouriteMovie;
    }

    public void setFavouriteMovie(String favouriteMovie) {
        this.favouriteMovie = favouriteMovie;
    }

    public String getFavouriteUnit() {
        return favouriteUnit;
    }

    public void setFavouriteUnit(String favouriteUnit) {
        this.favouriteUnit = favouriteUnit;
    }

    public String getCurrentJob() {
        return currentJob;
    }

    public void setCurrentJob(String currentJob) {
        this.currentJob = currentJob;
    }

    public String getMonashEmail() {
        return monashEmail;
    }

    public void setMonashEmail(String monashEmail) {
        this.monashEmail = monashEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(String subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    public String getSubscriptionTime() {
        return subscriptionTime;
    }

    public void setSubscriptionTime(String subscriptionTime) {
        this.subscriptionTime = subscriptionTime;
    }

    @XmlTransient
    public Collection<StudentLocation> getStudentLocationCollection() {
        return studentLocationCollection;
    }

    public void setStudentLocationCollection(Collection<StudentLocation> studentLocationCollection) {
        this.studentLocationCollection = studentLocationCollection;
    }

    @XmlTransient
    public Collection<StudentFriendRelation> getStudentFriendRelationCollection() {
        return studentFriendRelationCollection;
    }

    public void setStudentFriendRelationCollection(Collection<StudentFriendRelation> studentFriendRelationCollection) {
        this.studentFriendRelationCollection = studentFriendRelationCollection;
    }

    @XmlTransient
    public Collection<StudentFriendRelation> getStudentFriendRelationCollection1() {
        return studentFriendRelationCollection1;
    }

    public void setStudentFriendRelationCollection1(Collection<StudentFriendRelation> studentFriendRelationCollection1) {
        this.studentFriendRelationCollection1 = studentFriendRelationCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sid != null ? sid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.sid == null && other.sid != null) || (this.sid != null && !this.sid.equals(other.sid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MFFRest.Student[ sid=" + sid + " ]";
    }
    
}
