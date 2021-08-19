package com.polared.ganatalk.main.friend;

import java.util.Map;

public class FriendResponseDTO {
    private String nicName;
    private String profileImage;
    private String profileStatus;
    private Map<String, Object> friends;
    private Map<String, Object> oneOnoneChat;
    private Map<String, Object> roomId;

    public String getNicName() {
        return nicName;
    }

    public void setNicName(String nicName) {
        this.nicName = nicName;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getProfileStatus() {
        return profileStatus;
    }

    public void setProfileStatus(String profileStatus) {
        this.profileStatus = profileStatus;
    }

    public Map<String, Object> getFriends() {
        return friends;
    }

    public void setFriends(Map<String, Object> friends) {
        this.friends = friends;
    }

    public Map<String, Object> getOneOnoneChat() {
        return oneOnoneChat;
    }

    public void setOneOnoneChat(Map<String, Object> oneOnoneChat) {
        this.oneOnoneChat = oneOnoneChat;
    }

    public Map<String, Object> getRoomId() {
        return roomId;
    }

    public void setRoomId(Map<String, Object> roomId) {
        this.roomId = roomId;
    }
}
