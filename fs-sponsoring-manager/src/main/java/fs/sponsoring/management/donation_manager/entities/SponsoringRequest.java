package fs.sponsoring.management.donation_manager.value_objects;

public class SponsoringRequest {
    private final UUID id;
    private final String titleOfRequest;
    private final String formulaStudentTeamName;
    private final Sponsor sponsor;
    private double sponsoringBudget;

    public SponsoringRequest(UUID id, String formulaStudentTeamName, Sponsor sponsor, double sponsoringBudget) {
        this.id = Objects.requireNonNull(id);
        if (formulaStudentTeamName == null || formulaStudentTeamName.isEmpty()) {
            throw new IllegalArgumentException("Name of Formula Student Team cannot be null or empty");
        }
        this.sponsor = Objects.requiresNonNull(sponsor, "Sponsor cannot be null");

        if (sponsoringBudget <= 0) {
            throw new IllegalArgumentException("Sponsoring budget must be greater than 0");
        }

        this.titleOfRequest = "Sponsoring Request betwween " + formulaStudentTeamName + " and " + sponsor.getName();
        
        this.formulaStudentTeamName = formulaStudentTeamName;
        this.sponsoringBudget = sponsoringBudget;


    }

    public UUID getId() {
        return id;
    }

    public String getTitleOfRequest() {
        return titleOfRequest;
    }

    public String getFormulaStudentTeamName() {
        return formulaStudentTeamName;
    }

    public Sponsor getSponsor() {
        return sponsor;
    }

    public double getSponsoringBudget() {
        return sponsoringBudget;
    }

    public void updateSponsoringBudget(double newSponsoringBudget) {
        if (newSponsoringBudget <= 0) {
            throw new IllegalArgumentException("Sponsoring budget must be greater than 0");
        }
        this.sponsoringBudget = newSponsoringBudget;
    }

    public void convertToOfficialSponsoring(TeamMember teamMember) {
        if (teamMember == null && teamMember.getTeamRole() != Role.TEAM_CAPTAIN) {
            throw new IllegalArgumentException("Team member invalid");
        }
        
    }
}
