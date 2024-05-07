package com.alibou.security.user;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Collection;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.token.Token;
import org.springframework.security.core.userdetails.UserDetails;


//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//import java.util.Date;
//import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_user")


public class User  implements UserDetails {

    @Id
    @GeneratedValue
    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
//    private Date BirthDay_Date;
//    private Date issue_Date;

    @Enumerated(EnumType.STRING)
    private Role role;

   @OneToMany(mappedBy = "user")
   private List<Token> tokens;



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }


//    public User()
//    {
//        super();
//        //TODO AUTO_GENERATE CONSTRUCTOR
//    }
//    public User(int id,String firstName,String lastname, String email,String password,Date Birthday_Date,Date issue_Date){
//        super();
//        this.id = id;
//        this.firstName = firstName;
//        this.lastname = lastname;
//        this.email = email;
//        this.password = password;
//        this.BirthDay_Date = Birthday_Date;
//        this.issue_Date = issue_Date;
//
//    }
//
//    public int getId(){
//        return id;
//    }
//    public void setId(int id){
//        this.id = id;
//    }
//    public  String getFirstName(){
//        return firstName;
//    }
//    public void setFirstName(String firstName){
//         this.firstName = firstName;
//    }
//    public  String getLastName(){
//        return lastname;
//    }
//    public void setLastName(String lastname){
//       this.lastname = lastname;
//    }
//    public String getEmail(){
//        return email;
//    }
//    public void setEmail(String email){
//        this.email = email;
//    }



//    public String getPassword(){
//        return password;
//    }
//    public void setPassword(String password){
//        this.password = password;
//    }
//    public Date getBirthDay_Date(){
//        return BirthDay_Date;
//    }
//    public void setBirthDay_Date(){
//        this.BirthDay_Date = BirthDay_Date;
//    }
//    public Date getIssue_Date(){
//        return issue_Date;
//    }
//    public void setIssue_Date(){
//        this.issue_Date = issue_Date;
//    }
//
//    public String toString(){
//        return  "Users [ firstName = "+ firstName + ",lastname = " + lastname + ",email = "+ email + ",password = " + password +
//                ",BirthDay_Date = " + BirthDay_Date + ",issue_Date = " + issue_Date + " ]";
//    }


}
