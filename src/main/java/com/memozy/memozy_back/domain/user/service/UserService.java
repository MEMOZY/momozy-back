package com.memozy.memozy_back.domain.user.service;

import com.memozy.memozy_back.domain.user.domain.User;
import com.memozy.memozy_back.domain.user.dto.request.UpdateUserRequest;
import java.util.List;

public interface UserService {
    User getById(Long userId);
    User updateUserWithInfo(Long userId, UpdateUserRequest updateUserRequest);


//    List<UserPolicyAgreement> getPolicyAgreementList(Long userId);
//
//    List<UserPolicyAgreement> updatePolicyAgreement(Long userId, List<PolicyAgreementDto> policyAgreementDtoList);

}
