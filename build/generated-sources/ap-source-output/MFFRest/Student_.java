package MFFRest;

import MFFRest.StudentFriendRelation;
import MFFRest.StudentLocation;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-28T12:37:13")
@StaticMetamodel(Student.class)
public class Student_ { 

    public static volatile SingularAttribute<Student, String> lName;
    public static volatile SingularAttribute<Student, String> address;
    public static volatile SingularAttribute<Student, String> subrub;
    public static volatile SingularAttribute<Student, String> gender;
    public static volatile SingularAttribute<Student, String> favouriteUnit;
    public static volatile SingularAttribute<Student, String> monashEmail;
    public static volatile SingularAttribute<Student, String> subscriptionTime;
    public static volatile SingularAttribute<Student, String> nativeLanguage;
    public static volatile SingularAttribute<Student, String> favouriteSport;
    public static volatile SingularAttribute<Student, Integer> sid;
    public static volatile SingularAttribute<Student, String> subscriptionDate;
    public static volatile SingularAttribute<Student, String> password;
    public static volatile SingularAttribute<Student, String> fName;
    public static volatile SingularAttribute<Student, String> currentJob;
    public static volatile SingularAttribute<Student, String> nationality;
    public static volatile SingularAttribute<Student, String> favouriteMovie;
    public static volatile SingularAttribute<Student, String> dob;
    public static volatile CollectionAttribute<Student, StudentLocation> studentLocationCollection;
    public static volatile CollectionAttribute<Student, StudentFriendRelation> studentFriendRelationCollection;
    public static volatile SingularAttribute<Student, String> course;
    public static volatile SingularAttribute<Student, String> studyMode;
    public static volatile CollectionAttribute<Student, StudentFriendRelation> studentFriendRelationCollection1;

}