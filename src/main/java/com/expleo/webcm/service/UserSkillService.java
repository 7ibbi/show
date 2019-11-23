package com.expleo.webcm.service;

import com.expleo.webcm.entity.expleodb.Skill;
import com.expleo.webcm.entity.expleodb.UserExpleo;
import com.expleo.webcm.entity.expleodb.UserSkill;

import java.util.List;

public interface UserSkillService {

    List<UserSkill> getUserSkill();

    List<UserSkill> getUserSkillByUser(UserExpleo userExpleo);

    List<UserSkill> getUserSkillBySkill(Skill skill);

    List<UserSkill> getUserByEvaluation(List<UserSkill> userSkills, int eval);

    void removeUserSkill(int idUserExpleo, int idSkill);

    void saveUserSkill(int idUser, int idSkill);

    void saveUserSkill(int idUser, int idSkill, int eval);

}
