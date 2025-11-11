package CLI.eventSystem.observer;

import domainLogic.Administration;

public class AdministrationObserver implements Observer {
    Administration administration;

    public AdministrationObserver(Administration administration) {
        this.administration = administration;
    }

    @Override
    public void update() {
        System.out.println(administration.getStatus());
    }
}
