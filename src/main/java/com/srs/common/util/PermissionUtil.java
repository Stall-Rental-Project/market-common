package com.srs.common.util;

import org.springframework.util.CollectionUtils;

import java.util.Collection;


public class PermissionUtil {
    public static final String APPROVE_CHANGES_IN_THE_SYSTEM_MANAGEMENT = "APPROVE_CHANGES_IN_SYSTEM_MANAGEMENT";

    public static boolean canAutoApproveChangesInSystemManagement(Collection<String> permissions) {
        if (permissions == null) {
            return false;
        }

        return permissions.contains(APPROVE_CHANGES_IN_THE_SYSTEM_MANAGEMENT);
    }

    public static boolean canApproveChangesInSystemManagement(Collection<String> permissions) {
        if (permissions == null) {
            return false;
        }

        return permissions.contains(APPROVE_CHANGES_IN_THE_SYSTEM_MANAGEMENT);
    }

    // TODO: Update it
    public static boolean isPublicUser(Collection<String> roles) {
        return CollectionUtils.isEmpty(roles) || roles.contains("PUBLIC_USERS");
    }
}
