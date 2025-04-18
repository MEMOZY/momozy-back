package com.memozy.memozy_back.global.exception;


import static com.memozy.memozy_back.global.util.CommonConstant.MAX_TEXT_LENGTH;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class UserErrorMessage {

    // Common
    public static final String USER_IS_NULL = "User가 null 입니다.";
    public static final String USER_ID_IS_NULL = "회원 Id를 입력해주세요.";
    public static final String USER_NOT_EXISTING = "존재하지 않는 사용자입니다.";
    public static final String USER_ALREADY_DELETED = "이미 삭제된 사용자입니다.";
    public static final String USER_ID_NOT_EQUALS_LOGIN_ID = "로그인한 사용자의 Id가 프로필 회원 Id와 일치하지 않습니다.";

    // Nickname
    public static final String NICKNAME_IS_NULL = "닉네임을 입력해주세요.";
    public static final String NICKNAME_OVER_MAX_LENGTH =
            "닉네임은 " + 20 + "자 이하여야 합니다.";
    public static final String NICKNAME_DUPLICATE = "이미 사용중인 닉네임입니다.";

    // Profile Image URL
    public static final String PROFILE_IMAGE_URL_OVER_MAX_LENGTH =
            "프로필 이미지 url은 " + MAX_TEXT_LENGTH + "자 이하여야 합니다.";
    public static final String PROFILE_IMAGE_URL_IS_INVALID = "프로필 이미지 URL 형식이 유효하지 않습니다.";

    // Email
    public static final String EMAIL_FORMAT_INVALID = "이메일 형식이 올바르지 않습니다.";
    public static final String EMAIL_DUPLICATE = "이미 사용중인 이메일입니다.";
    public static final String EMAIL_IS_NULL = "이메일을 입력해주세요.";

    // Password
    public static final String PASSWORD_FORMAT_INVALID = "비밀번호 형식이 올바르지 않습니다.";
    public static final String PASSWORD_IS_NULL = "비밀번호를 입력해주세요.";
    public static final String NEW_PASSWORD_IS_NULL = "새로운 비밀번호를 입력해주세요.";
    public static final String PASSWORD_NOT_MATCH = "비밀번호가 일치하지 않습니다.";
    public static final String PASSWORD_IS_SAME_AS_BEFORE = "기존 비밀번호와 동일한 비밀번호입니다.";
    public static final String PASSWORD_NOT_REGISTERED = "소셜 로그인 회원입니다.";


}
