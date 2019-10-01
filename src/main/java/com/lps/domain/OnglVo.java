package com.lps.domain;

/**
 * ONGL
 */
public class OnglVo {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "OnglVo{" +
                "user=" + user +
                '}';
    }
}
