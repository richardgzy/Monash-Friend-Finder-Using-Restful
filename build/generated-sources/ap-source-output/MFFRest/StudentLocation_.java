package MFFRest;

import MFFRest.Student;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-28T12:37:13")
@StaticMetamodel(StudentLocation.class)
public class StudentLocation_ { 

    public static volatile SingularAttribute<StudentLocation, String> locationName;
    public static volatile SingularAttribute<StudentLocation, String> recordTime;
    public static volatile SingularAttribute<StudentLocation, Integer> locationId;
    public static volatile SingularAttribute<StudentLocation, String> latitude;
    public static volatile SingularAttribute<StudentLocation, String> longtitude;
    public static volatile SingularAttribute<StudentLocation, String> recordDate;
    public static volatile SingularAttribute<StudentLocation, Student> sid;

}