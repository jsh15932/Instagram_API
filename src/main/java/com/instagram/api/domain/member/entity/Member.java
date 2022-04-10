package com.instagram.api.domain.member.entity;

import com.instagram.api.domain.follow.entity.Follow;
import com.instagram.api.global.vo.Image;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Table(name = "members")
public class Member {

    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false, length = 20, unique = true)
    private String username;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private MemberRole role;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "website")
    private String website;

    @Lob
    @Column(name = "introduce")
    private String introduce;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToMany(mappedBy = "member")
    private List<Follow> followings = new ArrayList<>();

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "imageUrl", column = @Column(name = "member_image_url")),
            @AttributeOverride(name = "imageType", column = @Column(name = "member_image_type")),
            @AttributeOverride(name = "imageName", column = @Column(name = "member_image_name")),
            @AttributeOverride(name = "imageUUID", column = @Column(name = "member_image_uuid"))
    })
    private Image image;

    public void updateUsername(String username) {
        this.username = username;
    }

    public void updateName(String name) {
        this.name = name;
    }

    public void updateWebsite(String website) {
        this.website = website;
    }

    public void updateIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public void updatePhone(String phone) {
        this.phone = phone;
    }

    public void updateEmail(String email) {
        this.email = email;
    }

    public void updateGender(Gender gender) {
        this.gender = gender;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.password = encryptedPassword;
    }

    @Builder
    public Member(String username, String name, String password, String email) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.email = email;

        this.role = MemberRole.ROLE_USER;
        this.gender = Gender.PRIVATE;
    }
}