package com.techelevator.model;

public class Guest {
    
    public Guest(Long guestId, Long userId) {
        this.guestId = guestId;
        this.userId = userId;
    }
    private Long guestId;
    private Long userId;
    
    public Long getGuestId() {
        return guestId;
    }
    public Long getUserId() {
        return userId;
    }
    
}
