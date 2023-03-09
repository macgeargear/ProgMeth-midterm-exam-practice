package logic;

import java.util.ArrayList;

import java.lang.Exception;

public class Server {
    private String name;
    private User owner;
    private ArrayList<Channel> channelList;
    private ArrayList<User> memberList;

    public Server(String name, User owner, TemplateType template) {
        this.owner = owner;
        this.channelList = new ArrayList<Channel>();
        this.memberList = new ArrayList<User>();
        this.memberList.add(owner);
        owner.addJoinedServersList(this);

        this.setName(name);

        if (template == TemplateType.BASIC) {
            this.addChannel(owner, "general");
        } else if (template == TemplateType.GAMING) {
            this.addChannel(owner, "gaming");
        } else {
            this.addChannel(owner, "homework-help");
        }

    }

    public Channel addChannel(User user, String channelName) {
        if (this.getOwner().equals(user)) {
            Channel ch = new Channel(channelName);
            this.channelList.add(ch);
            return ch;
        } else {
            return null;
        }
    }

    public User addUser(User user) {
        if (!this.memberList.contains(user)) {
            this.memberList.add(user);
            user.addJoinedServersList(this);
            return user;
        } else {
            return null;
        }
    }

    public boolean kickUser(User kicker, User kicked) throws Exception {
        if (!this.owner.equals(kicker)) {
            throw new Exception();
        } else if (this.owner.equals(kicker) && (!this.memberList.contains(kicked) || this.owner.equals(kicked))) {
                return false;
        } else {
            kicked.getJoinedServersList().remove(this);
            this.memberList.remove(kicked);
            return true;
        }
    }

    public void setName(String name) {
        if (name.isBlank() || name.isEmpty()) {
            this.name = this.owner.getName() + " " + "home";
        } else {
            this.name = name;
        }
    }

    public String getName() {
        return this.name;
    }

    public User getOwner() {
        return this.owner;
    }

    public ArrayList<Channel> getChannelList() {
        return this.channelList;
    }

    public ArrayList<User> getMemberList() {
        return this.memberList;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
    public void setChannelList(ArrayList<Channel> channelList) {
        this.channelList = channelList;
    }
    public void setMemberList(ArrayList<User> memberList) {
        this.memberList = memberList;
    }


}
