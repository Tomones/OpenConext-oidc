package oidc.model;

import org.mitre.openid.connect.model.DefaultUserInfo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user_info")
public class FederatedUserInfo extends DefaultUserInfo {

  private String schacHomeOrganization;
  private String unspecifiedNameId;
  private String schacHomeOrganizationType;
  private String eduPersonPrincipalName;
  private String eduPersonTargetedId;

  private Set<String> eduPersonAffiliations = new HashSet<>();
  private Set<String> eduPersonScopedAffiliations = new HashSet<>();
  private Set<String> isMemberOfs = new HashSet<>();
  private Set<String> eduPersonEntitlements = new HashSet<>();
  private Set<String> schacPersonalUniqueCode = new HashSet<>();
  private Set<String> uids = new HashSet<>();

  @Basic
  @Column(name = "schac_home_organization")
  public String getSchacHomeOrganization() {
    return schacHomeOrganization;
  }

  public void setSchacHomeOrganization(String schacHomeOrganization) {
    this.schacHomeOrganization = schacHomeOrganization;
  }

  @Basic
  @Column(name = "unspecified_name_id")
  public String getUnspecifiedNameId() {
    return unspecifiedNameId;
  }

  public void setUnspecifiedNameId(String unspecifiedNameId) {
    this.unspecifiedNameId = unspecifiedNameId;
  }

  @Basic
  @Column(name = "schac_home_organization_type")
  public String getSchacHomeOrganizationType() {
    return schacHomeOrganizationType;
  }

  public void setSchacHomeOrganizationType(String schacHomeOrganizationType) {
    this.schacHomeOrganizationType = schacHomeOrganizationType;
  }

  @Basic
  @Column(name = "edu_person_principal_name")
  public String getEduPersonPrincipalName() {
    return eduPersonPrincipalName;
  }

  public void setEduPersonPrincipalName(String eduPersonPrincipalName) {
    this.eduPersonPrincipalName = eduPersonPrincipalName;
  }

  @Basic
  @Column(name = "edu_person_targeted_id")
  public String getEduPersonTargetedId() {
    return eduPersonTargetedId;
  }

  public void setEduPersonTargetedId(String eduPersonTargetedId) {
    this.eduPersonTargetedId = eduPersonTargetedId;
  }

  @ElementCollection(fetch = FetchType.EAGER)
  @CollectionTable(
      name = "user_edu_person_affiliation",
      joinColumns = @JoinColumn(name = "user_id")
  )
  @Column(name = "edu_person_affiliation")
  public Set<String> getEduPersonAffiliations() {
    return eduPersonAffiliations;
  }

  public void setEduPersonAffiliations(Set<String> eduPersonAffiliations) {
    this.eduPersonAffiliations = eduPersonAffiliations;
  }

  @ElementCollection(fetch = FetchType.EAGER)
  @CollectionTable(
      name = "user_edu_person_scoped_affiliation",
      joinColumns = @JoinColumn(name = "user_id")
  )
  @Column(name = "edu_person_scoped_affiliation")
  public Set<String> getEduPersonScopedAffiliations() {
    return eduPersonScopedAffiliations;
  }

  public void setEduPersonScopedAffiliations(Set<String> eduPersonScopedAffiliations) {
    this.eduPersonScopedAffiliations = eduPersonScopedAffiliations;
  }

  @ElementCollection(fetch = FetchType.EAGER)
  @CollectionTable(
      name = "user_is_member_of",
      joinColumns = @JoinColumn(name = "user_id")
  )
  @Column(name = "is_member_of")
  public Set<String> getIsMemberOfs() {
    return isMemberOfs;
  }

  public void setIsMemberOfs(Set<String> isMemberOfs) {
    this.isMemberOfs = isMemberOfs;
  }

  @ElementCollection(fetch = FetchType.EAGER)
  @CollectionTable(
      name = "user_edu_person_entitlement",
      joinColumns = @JoinColumn(name = "user_id")
  )
  @Column(name = "edu_person_entitlement")
  public Set<String> getEduPersonEntitlements() {
    return eduPersonEntitlements;
  }

  public void setEduPersonEntitlements(Set<String> eduPersonEntitlements) {
    this.eduPersonEntitlements = eduPersonEntitlements;
  }

  @ElementCollection(fetch = FetchType.EAGER)
  @CollectionTable(
      name = "user_schac_personal_unique_code",
      joinColumns = @JoinColumn(name = "user_id")
  )
  @Column(name = "schac_personal_unique_code")
  public Set<String> getSchacPersonalUniqueCode() {
    return schacPersonalUniqueCode;
  }

  public void setSchacPersonalUniqueCode(Set<String> schacPersonalUniqueCode) {
    this.schacPersonalUniqueCode = schacPersonalUniqueCode;
  }

  @ElementCollection(fetch = FetchType.EAGER)
  @CollectionTable(
      name = "user_uid",
      joinColumns = @JoinColumn(name = "user_id")
  )
  @Column(name = "uid")
  public Set<String> getUids() {
    return uids;
  }

  public void setUids(Set<String> uids) {
    this.uids = uids;
  }
}