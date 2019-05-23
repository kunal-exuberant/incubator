package likedriving.design.ComboOffer.models;

import java.util.*;

public class Workflow implements IWorkflow{

    private ComboStore comboStore;


    public Workflow(ComboStore comboStore){
        this.comboStore = comboStore;
    }

    @Override
    public void createCombo(Scanner sc) {

        Zulu zulu = new Zulu();

       // zulu.getZulu().get()


        System.out.println("Enter number of product groups in combo");
        int productGroup = sc.nextInt();
        if(!(productGroup > 0 && productGroup <= 5)) {
            throw new IllegalArgumentException("No of product groups can be at most 5");
        }

        List<String> productGroups = new ArrayList<>();

        for(int i=0; i< productGroup; i++){
            productGroups.add("pg"+(i+1));
        }

        System.out.println("Please specify the disbursal rule");
        int i=1;
        for(DisbursalType disbursalType: DisbursalType.values()) {
            System.out.println(i+". "+disbursalType.toString());
            i++;
        }
        DisbursalRule disbursalRule = null;
        switch(sc.nextInt()){
            case -1:
                System.out.println("Enter final price of combo ");
                int finalPrice = sc.nextInt();
                if(!(finalPrice > 0 && finalPrice < 100000)){
                    throw new IllegalArgumentException();
                }
                disbursalRule = new FinalPriceCombo(finalPrice);
                break;
            case 1:
                System.out.println("Enter percentage discount of combo ");
                int percentageCombo = sc.nextInt();
                if(!(percentageCombo > 0 && percentageCombo < 100)){
                    throw new IllegalArgumentException();
                }
                disbursalRule = new PercentageDiscountCombo(percentageCombo);
                break;
            case 2:
                System.out.println("Enter flat discount on combo ");
                int flatCombo = sc.nextInt();
                if(!(flatCombo > 0 && flatCombo < 10000)){
                    throw new IllegalArgumentException();
                }
                disbursalRule = new FixedDiscountCombo(flatCombo);
                break;
            case 4:
                System.out.println("Enter final selling price of each cohort ");

                int flatCohort = -1;
                Map<String, Price> pgPriceMap = new HashMap<>();
                for(int j=0; j< productGroup; j++){
                    flatCohort = sc.nextInt();
                    if(!(flatCohort > 0 && flatCohort < 10000)){
                        throw new IllegalArgumentException();
                    }
                    pgPriceMap.put("pg"+(i+1), new Price(PriceType.SP, flatCohort));
                }
                disbursalRule = new FinalPriceCohort(pgPriceMap);
                break;
            default:
        }
        Offer offer = new Offer(productGroups, disbursalRule);
        comboStore.add(offer);
    }

    @Override
    public void buyCombo(Scanner sc) {
        System.out.println("Buying combo");

        for(Offer offer: comboStore.getComboStore()){

            System.out.println(offer);

        }
    }

    public static void main(String[] args) {

        Workflow workflow = new Workflow(new ComboStore());

        Zulu zulu = new Zulu();

        boolean exitProgram = false;

        while(true) {

            System.out.println("Please select one of the following");
            System.out.println("1. Create Combo");
            System.out.println("2. Buy Combo");
            System.out.println("3. Exit");

            Scanner sc = new Scanner(System.in);

            int menuOption = sc.nextInt();

          /*  if(Integer.parseInt(menuOption)){
                System.out.println("Invalid menu option selected");
            }*/

            switch (menuOption) {
                case 1:

                    List<ListingId> listingIdList = new ArrayList<>();
                    //listingIdList.add(zulu.getZulu().get(new ListingId(1)));
                    //listingIdList.add(zulu.getZulu().get(new ListingId(2)))

                    workflow.createCombo(sc);
                    System.out.println("case 1");
                    break;
                case 2:

                    workflow.buyCombo(sc);
                    System.out.println("case 2");
                    break;

                case 3:
                    exitProgram = true;
                    break;
                default:
                    System.out.println("Unexpected case");
            }

            if(exitProgram){
                System.out.println("Shutting down ...");
                break;
            }
        }
    }
}
