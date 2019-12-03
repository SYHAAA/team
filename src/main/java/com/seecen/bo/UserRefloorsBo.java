package com.seecen.bo;

import com.seecen.domain.ReviewerInformation;
import com.seecen.domain.TabUser;
import com.seecen.domain.TieziMessage;
import com.seecen.domain.UserRloors;

public class UserRefloorsBo {
    private TieziMessage tieziMessage = new TieziMessage();
    private UserRloors userRloors = new UserRloors();
    private ReviewerInformation reviewerInformation =new ReviewerInformation() ;
    private TabUser tabUser =new TabUser();

    public TabUser getTabUser() {
        return tabUser;
    }

    public void setTabUser(TabUser tabUser) {
        this.tabUser = tabUser;
    }

    public ReviewerInformation getReviewerInformation() {
        return reviewerInformation;
    }

    public void setReviewerInformation(ReviewerInformation reviewerInformation) {
        this.reviewerInformation = reviewerInformation;
    }

    public TieziMessage getTieziMessage() {
        return tieziMessage;
    }

    public void setTieziMessage(TieziMessage tieziMessage) {
        this.tieziMessage = tieziMessage;
    }

    public UserRloors getUserRloors() {
        return userRloors;
    }

    public void setUserRloors(UserRloors userRloors) {
        this.userRloors = userRloors;
    }
}
