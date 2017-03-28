package MFFRest;

import MFFRest.Student;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-28T12:37:13")
@StaticMetamodel(StudentFriendRelation.class)
public class StudentFriendRelation_ { 

    public static volatile SingularAttribute<StudentFriendRelation, Integer> friendshipid;
    public static volatile SingularAttribute<StudentFriendRelation, String> endingDate;
    public static volatile SingularAttribute<StudentFriendRelation, String> startingDate;
    public static volatile SingularAttribute<StudentFriendRelation, Student> hasFriend;
    public static volatile SingularAttribute<StudentFriendRelation, Student> sid;

}