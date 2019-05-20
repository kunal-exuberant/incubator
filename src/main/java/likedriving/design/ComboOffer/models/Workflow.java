package likedriving.design.ComboOffer.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Workflow implements IWorkflow{
    @Override
    public void createCombo() {






        Offer offer = new Offer();
        //offer.createOffer();

    }

    @Override
    public void buyCombo() {

    }

    public static void main(String[] args) {

        Workflow workflow = new Workflow();

        Zulu zulu = new Zulu();

        Scanner sc = new Scanner(System.in);
        switch (sc.nextInt()) {
            case 1:

                List<ListingId> listingIdList = new ArrayList<>();
                //listingIdList.add(zulu.getZulu().get(new ListingId(1)));
                //listingIdList.add(zulu.getZulu().get(new ListingId(2)))

                workflow.createCombo();
                System.out.println("case 1");
                break;
            case 2:
                System.out.println("case 2");
                break;
            default:
                System.out.println("Unexpected case");
        }
    }
}
