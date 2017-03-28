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
@Table(name = "STUDENT_LOCATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudentLocation.findAll", query = "SELECT s FROM StudentLocation s")
    , @NamedQuery(name = "StudentLocation.findByLocationId", query = "SELECT s FROM StudentLocation s WHERE s.locationId = :locationId")
    , @NamedQuery(name = "StudentLocation.findByLatitude", query = "SELECT s FROM StudentLocation s WHERE s.latitude = :latitude")
    , @NamedQuery(name = "StudentLocation.findByLongtitude", query = "SELECT s FROM StudentLocation s WHERE s.longtitude = :longtitude")
    , @NamedQuery(name = "StudentLocation.findByLocationName", query = "SELECT s FROM StudentLocation s WHERE s.locationName = :locationName")
    , @NamedQuery(name = "StudentLocation.findByRecordDate", query = "SELECT s FROM StudentLocation s WHERE s.recordDate = :recordDate")
    , @NamedQuery(name = "StudentLocation.findByRecordTime", query = "SELECT s FROM StudentLocation s WHERE s.recordTime = :recordTime")
    })
public class StudentLocation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "LOCATION_ID")
    private Integer locationId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "LATITUDE")
    private String latitude;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "LONGTITUDE")
    private String longtitude;
    @Size(max = 100)
    @Column(name = "LOCATION_NAME")
    private String locationName;
    @Size(max = 10)
    @Column(name = "RECORD_DATE")
    private String recordDate;
    @Size(max = 8)
    @Column(name = "RECORD_TIME")
    private String recordTime;
    @JoinColumn(name = "SID", referencedColumnName = "SID")
    @ManyToOne
    private Student sid;

    public StudentLocation() {
    }

    public StudentLocation(Integer locationId) {
        this.locationId = locationId;
    }

    public StudentLocation(Integer locationId, String latitude, String longtitude) {
        this.locationId = locationId;
        this.latitude = latitude;
        this.longtitude = longtitude;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(String longtitude) {
        this.longtitude = longtitude;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(String recordDate) {
        this.recordDate = recordDate;
    }

    public String getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(String recordTime) {
        this.recordTime = recordTime;
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
        hash += (locationId != null ? locationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentLocation)) {
            return false;
        }
        StudentLocation other = (StudentLocation) object;
        if ((this.locationId == null && other.locationId != null) || (this.locationId != null && !this.locationId.equals(other.locationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MFFRest.StudentLocation[ locationId=" + locationId + " ]";
    }
    
}
