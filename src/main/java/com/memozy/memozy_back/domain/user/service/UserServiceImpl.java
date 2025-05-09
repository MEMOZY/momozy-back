package com.memozy.memozy_back.domain.user.service;

import com.memozy.memozy_back.domain.user.domain.User;
import com.memozy.memozy_back.domain.user.dto.request.UpdateUserRequest;
import com.memozy.memozy_back.domain.user.repository.UserRepository;
import com.memozy.memozy_back.global.exception.BusinessException;
import com.memozy.memozy_back.global.exception.ErrorCode;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
//    private final UserPolicyAgreementRepository userPolicyAgreementRepository;


    @Override
    @Transactional(readOnly = true)
    public User getById(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new BusinessException(
                ErrorCode.NOT_FOUND_RESOURCE_EXCEPTION));
    }

    @Override
    @Transactional
    public User updateUserWithInfo(Long userId, UpdateUserRequest updateUserRequest) {
        var user = userRepository.findById(userId).orElseThrow(() -> new BusinessException(
                ErrorCode.NOT_FOUND_RESOURCE_EXCEPTION));
        user.updateUserInfo(updateUserRequest);
        return user;
    }

//    @Override
//    @Transactional
//    public List<UserPolicyAgreement> updatePolicyAgreement(Long userId,
//            List<PolicyAgreementDto> policyAgreementDtoList) {
//        var user = userRepository.findById(userId).orElseThrow(() -> new BusinessException(
//                ErrorCode.NOT_FOUND_RESOURCE_EXCEPTION));
//        var existPolicyAgreementList = userPolicyAgreementRepository.findAllByUserId(userId);
//
//        var policyAgreementListForSave = policyAgreementDtoList.stream().map(
//                dto -> existPolicyAgreementList.stream()
//                        .filter(
//                                policyAgreement -> policyAgreement.getPolicyType().equals(dto.policyType()))
//                        .findFirst()
//                        .map(policyAgreement -> policyAgreement.updateIsAgree(dto.isAgree()))
//                        .orElse(UserPolicyAgreement.builder()
//                                .user(user)
//                                .policyType(dto.policyType())
//                                .version(dto.version())
//                                .isAgree(dto.isAgree())
//                                .build())
//        ).toList();
//
//        return userPolicyAgreementRepository.saveAll(policyAgreementListForSave);
//    }

    @Override
    @Transactional
    public void withdrawUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new BusinessException(ErrorCode.NOT_FOUND_USER_EXCEPTION));

        userRepository.delete(user); // 완전 삭제
    }
}
