package com.expleo.webcm.dao;

import com.expleo.webcm.entity.expleodb.Skill;
import com.expleo.webcm.entity.expleodb.UserExpleo;
import com.expleo.webcm.entity.expleodb.UserSkill;

import java.util.List;

public interface UserSkillDAO {

    List<UserSkill> getUserSkill();

    List<UserSkill> getUserSkillByUser(UserExpleo userExpleo);

    void getUserByEvaluation(List<UserSkill> userSkills, int eval);

    void removeUserSkill(int idUserExpleo, int idSkill);

    void saveUserSkill(int idUser, int idSkill);

    void saveUserSkill(int idUser, int idSkill, int eval);


    void getAdditionalAndProjectSkill(int userId, List<UserSkill> userAdditionalSkills, List<UserSkill> projectSkills);

    List<UserSkill> getUserSkillByProjectSkills(Integer projectId);
}
