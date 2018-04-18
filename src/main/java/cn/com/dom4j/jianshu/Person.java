package cn.com.dom4j.jianshu;

import java.util.List;

public class Person {

    private String name;
    private String gender;
    private String phone;
    private String qq;
    private String weChat;
    private String education;
    private String address;
    private String major;
    private String github;
    private String blog;
    private String Email;

    private String workExperience;
    private List<String> projectExperience;
    private List<String> skill;


    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWeChat() {
        return weChat;
    }

    public void setWeChat(String weChat) {
        this.weChat = weChat;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(String workExperience) {
        this.workExperience = workExperience;
    }

    public List<String> getProjectExperience() {
        return projectExperience;
    }

    public void setProjectExperience(List<String> projectExperience) {
        this.projectExperience = projectExperience;
    }

    public List<String> getSkill() {
        return skill;
    }

    public void setSkill(List<String> skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {

        StringBuilder project = new StringBuilder();
        List<String> projectExperience = getProjectExperience();
        if (projectExperience != null && projectExperience.size() != 0) {
            int index = 1;
            for (String s : projectExperience) {
                project.append(index++).append(") ").append(s).append("\n");
            }
        }

        StringBuilder skills = new StringBuilder();
        List<String> skill = getSkill();
        if (skill != null && skill.size() != 0) {
            int index = 1;
            for (String s : skill) {
                skills.append(index++).append(") ").append(s).append("\n");
            }
        }


        return "               个人简介         \n" +
                "\n              基本信息" +
                "\n姓名: " + name +
                "\n性别: " + gender +
                "\n电话: " + phone + " (QQ: "+ qq + "  微信: " + weChat + ") " +
                "\n学历: " + education +
                "\n住址: " + address +
                "\n专业: " + major +
                "\nGithub: " + github +
                "\n博客: " + blog +
                "\n邮箱: " + Email + "\n" +
                "\n               工作经验" +
                "\n" + workExperience + "\n" +
                "\n               项目经验       " +
                "\n" + project.toString() + "\n" +
                "\n               专业技能        " +
                "\n" + skills.toString() + "\n"

                ;
    }
}
