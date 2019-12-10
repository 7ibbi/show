package com.expleo.webcm.service;

import com.expleo.webcm.dao.UserSkillDAO;
import com.expleo.webcm.entity.expleodb.UserExpleo;
import com.expleo.webcm.entity.expleodb.UserSkill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserSkillServiceImpl implements UserSkillService {

    @Autowired
    private UserSkillDAO userSkillDAO;

    @Override
    @Transactional("transactionExpleoDBManager")
    public List<UserSkill> getUserSkill() {
        return userSkillDAO.getUserSkill();
    }

    @Override
    @Transactional("transactionExpleoDBManager")
    public List<UserSkill> getUserSkillByUser(UserExpleo userExpleo) {
        return userSkillDAO.getUserSkillByUser(userExpleo);
    }

    @Override
    public void getUserByEvaluation(List<UserSkill> userSkills, int eval) {
        userSkillDAO.getUserByEvaluation(userSkills,eval);
    }

    @Override
    @Transactional("transactionExpleoDBManager")
    public void removeUserSkill(int idUserExpleo, int idSkill) {
        userSkillDAO.removeUserSkill(idUserExpleo,idSkill);
    }

    @Override
    @Transactional("transactionExpleoDBManager")
    public void saveUserSkill(int idUser, int idSkill) {
        userSkillDAO.saveUserSkill(idUser,idSkill);
    }

    @Override
    @Transactional("transactionExpleoDBManager")
    public void saveUserSkill(int idUser, int idSkill, int eval) {
        userSkillDAO.saveUserSkill(idUser, idSkill, eval);
    }

    @Override
    @Transactional("transactionExpleoDBManager")
    public void getAdditionalAndProjectSkill(int userId, List<UserSkill> userAdditionalSkills, List<UserSkill> projectSkills) {
        userSkillDAO.getAdditionalAndProjectSkill(userId, userAdditionalSkills, projectSkills);
    }

    @Override
    @Transactional("transactionExpleoDBManager")
    public List<UserSkill> getUserSkillByProjectSkills(Integer projectId) {
        return userSkillDAO.getUserSkillByProjectSkills(projectId);
    }
}
