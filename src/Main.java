import java.text.DecimalFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        DecimalFormat amountOfDecimal = new DecimalFormat("0.00");
        DecimalFormat amountOfDecimalWeight = new DecimalFormat("0.000");
        // I created decimal formats because I want prices to have two decimal points and I want weight to have three decimal points

        double weightLimit = 52.5;
        // Defining the weight limit

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Material Codes (Leave one space between codes): ");
        String materialCodes = scanner.nextLine();
        String[] materialCodesList = materialCodes.split(" ");
        List<String> codes = new ArrayList<>(Arrays.asList(materialCodesList));
        // Taking material codes input

        boolean cFlag = false;
        boolean rFlag = false;

        List<String> modifiedCodes = new ArrayList<>();

        for (String code : codes) {
            if (code.contains("C")) {
                modifiedCodes.add("5: CB");
                cFlag = true;
            } else if (code.contains("RS")) {
                modifiedCodes.add("5: RSL");
                rFlag = true;
            }
            modifiedCodes.add(code);
        }
        // Create a separate list to hold the modified codes

        if (rFlag && cFlag) {
            modifiedCodes.remove("5:");
            modifiedCodes.remove("5:");
            modifiedCodes.remove("CB");
            modifiedCodes.remove("RSL");
        } else if (cFlag) {
            modifiedCodes.remove("5:");
            modifiedCodes.remove("CB");
        } else if (rFlag) {
            modifiedCodes.remove("5:");
            modifiedCodes.remove("RSL");
        }
        // Because the program separates codes according to spaces if the input is 5: CB the program thinks it is 5: and CB so this code prevents it

        System.out.println("Enter Amount of Material (Leave one space between codes): ");
        String materialAmountsStr = scanner.nextLine();
        String[] materialAmountsList = materialAmountsStr.split(" ");
        List<Double> amounts = new ArrayList<>();
        for (String amountStr : materialAmountsList) {
            amounts.add(Double.parseDouble(amountStr));
        }
        // Taking material amount input

        HashMap<String, Double> priceMap = new HashMap<>();
        HashMap<String, Double> weighMap = new HashMap<>();
        HashMap<String, Double> defaultWeighMap = new HashMap<>();
        // Defining all the lists I am going to use

        int sizeCodes = modifiedCodes.size();
        // Defining size of codes

        while (!(amounts.size() == sizeCodes)) {
            System.out.println("Number of amounts don't match with number of materials");
            System.out.println("Enter Amount of Material (Leave one space between codes): ");
            materialAmountsStr = scanner.nextLine();
            materialAmountsList = materialAmountsStr.split(" ");
            amounts = new ArrayList<>();
            for (String amountStr : materialAmountsList) {
                amounts.add(Double.parseDouble(amountStr));
            }
        }
        // If the number of amounts and codes don't match ask the user until they input amounts that match with codes

        for (int i = 0; i < sizeCodes; i++) {
            switch (modifiedCodes.get(i)) {
                case "4.1":
                    double aamount = amounts.get(i);
                    double aprice = aamount * 50;
                    double aweight = 0.01;
                    double afinalweight = aweight * aamount;
                    // Defining variables

                    while (!(aamount == Math.floor(aamount)) || !(amounts.size() == sizeCodes)) {
                        System.out.println("You can't write decimal numbers to materials that are bought with integers");
                        System.out.println("Enter Amount of Material (Leave one space between codes): ");
                        materialAmountsStr = scanner.nextLine();
                        materialAmountsList = materialAmountsStr.split(" ");
                        amounts = new ArrayList<>();
                        for (String amountStr : materialAmountsList) {
                            amounts.add(Double.parseDouble(amountStr));
                        }
                        // If decimal number is written in a material that is bought one by one program asks the user again and again until user gives an integer for a material that is bought one by one

                        if (!(amounts.size() == sizeCodes)) {
                            System.out.println("Number of amounts don't match with number of materials");
                            System.out.println("Enter Amount of Material (Leave one space between codes): ");
                            materialAmountsStr = scanner.nextLine();
                            materialAmountsList = materialAmountsStr.split(" ");
                            amounts = new ArrayList<>();
                            for (String amountStr : materialAmountsList) {
                                amounts.add(Double.parseDouble(amountStr));
                            }
                        }
                        // Also because user can solve decimal problem but write wrong number of amounts we are checking the number in every loop

                        aamount = amounts.get(i);
                        aprice = aamount * 50;
                        afinalweight = aweight * aamount;
                        // Redefining variables after every loop
                    }

                    priceMap.put("Encoder", aprice);
                    weighMap.put("Encoder", afinalweight);
                    defaultWeighMap.put("Encoder", aweight);
                    // Putting variables into the hash maps to use them in the future
                    break;

                case "4.2M":
                    double bamount = amounts.get(i);
                    double bprice = bamount * 200;
                    double bweight = 0.03;
                    double bfinalweight = bweight * bamount;
                    // Defining variables

                    while (!(bamount == Math.floor(bamount)) || !(amounts.size() == sizeCodes)) {
                        System.out.println("You can't write decimal numbers to materials that are bought with integers");
                        System.out.println("Enter Amount of Material (Leave one space between codes): ");
                        materialAmountsStr = scanner.nextLine();
                        materialAmountsList = materialAmountsStr.split(" ");
                        amounts = new ArrayList<>();
                        for (String amountStr : materialAmountsList) {
                            amounts.add(Double.parseDouble(amountStr));
                        }
                        // If decimal number is written in a material that is bought one by one program asks the user again and again until user gives an integer for a material that is bought one by one


                        if (!(amounts.size() == sizeCodes)) {
                            System.out.println("Number of amounts don't match with number of materials");
                            System.out.println("Enter Amount of Material (Leave one space between codes): ");
                            materialAmountsStr = scanner.nextLine();
                            materialAmountsList = materialAmountsStr.split(" ");
                            amounts = new ArrayList<>();
                            for (String amountStr : materialAmountsList) {
                                amounts.add(Double.parseDouble(amountStr));
                            }
                        }
                        // Also because user can solve decimal problem but write wrong number of amounts we are checking the number in every loop

                        bamount = amounts.get(i);
                        bprice = bamount * 50;
                        // Redefining variables after every loop
                    }

                    priceMap.put("Magnetic Encoder", bprice);
                    weighMap.put("Magnetic Encoder", bfinalweight);
                    defaultWeighMap.put("Magnetic Encoder", bweight);
                    // Putting variables into the hash maps to use them in the future
                    break;

                case "3.1":
                    double camount = amounts.get(i);
                    double cprice = camount * 30;
                    double cweight = 0.05;
                    double cfinalweight = cweight * camount;
                    // Defining variables

                    priceMap.put("Polikarbon Plaka", cprice);
                    weighMap.put("Polikarbon Plaka", cfinalweight);
                    defaultWeighMap.put("Polikarbon Plaka", cweight);
                    // Putting variables into the hash maps to use them in the future
                    break;

                case "3.2-2":
                    double damount = amounts.get(i);
                    double dprice = damount * 50;
                    double dweight = 3.5;
                    double dfinalweight = dweight * damount;
                    // Defining variables

                    priceMap.put("Alüminyum 2024 Plaka", dprice);
                    weighMap.put("Alüminyum 2024 Plaka", dfinalweight);
                    defaultWeighMap.put("Alüminyum 2024 Plaka", dweight);
                    // Putting variables into the hash maps to use them in the future
                    break;

                case "3.2-4":
                    double eamount = amounts.get(i);
                    double eprice = eamount * 30;
                    double eweight = 4.5;
                    double efinalweight = eweight * eamount;
                    // Defining variables

                    priceMap.put("Alüminyum 4145 Plaka", eprice);
                    weighMap.put("Alüminyum 4145 Plaka", efinalweight);
                    defaultWeighMap.put("Alüminyum 4145 Plaka", eweight);
                    // Putting variables into the hash maps to use them in the future
                    break;

                case "2.Omni":
                    double famount = amounts.get(i);
                    double fprice = famount * 20;
                    double fweight = 0.4;
                    double ffinalweight = fweight * famount;
                    // Defining variables

                    while (!(famount == Math.floor(famount)) || !(amounts.size() == sizeCodes)) {
                        System.out.println("You can't write decimal numbers to materials that are bought with integers");
                        System.out.println("Enter Amount of Material (Leave one space between codes): ");
                        materialAmountsStr = scanner.nextLine();
                        materialAmountsList = materialAmountsStr.split(" ");
                        amounts = new ArrayList<>();
                        for (String amountStr : materialAmountsList) {
                            amounts.add(Double.parseDouble(amountStr));
                        }
                        // If decimal number is written in a material that is bought one by one program asks the user again and again until user gives an integer for a material that is bought one by one

                        if (!(amounts.size() == sizeCodes)) {
                            System.out.println("Number of amounts don't match with number of materials");
                            System.out.println("Enter Amount of Material (Leave one space between codes): ");
                            materialAmountsStr = scanner.nextLine();
                            materialAmountsList = materialAmountsStr.split(" ");
                            amounts = new ArrayList<>();
                            for (String amountStr : materialAmountsList) {
                                amounts.add(Double.parseDouble(amountStr));
                            }
                        }
                        // Also because user can solve decimal problem but write wrong number of amounts we are checking the number in every loop

                        famount = amounts.get(i);
                        fprice = famount * 50;
                        ffinalweight = fweight * famount;
                        // Redefining variables after every loop
                    }

                    priceMap.put("Omniwheel", fprice);
                    weighMap.put("Omniwheel", ffinalweight);
                    defaultWeighMap.put("Omniwheel", fweight);
                    // Putting variables into the hash maps to use them in the future
                    break;

                case "2.\"6in\"":
                    double gamount = amounts.get(i);
                    double gprice = gamount * 15;
                    double gweight = 0.3;
                    double gfinalweight = gweight * gamount;
                    // Defining variables


                    while (!(gamount == Math.floor(gamount)) || !(amounts.size() == sizeCodes)) {
                        System.out.println("You can't write decimal numbers to materials that are bought with integers");
                        System.out.println("Enter Amount of Material (Leave one space between codes): ");
                        materialAmountsStr = scanner.nextLine();
                        materialAmountsList = materialAmountsStr.split(" ");
                        amounts = new ArrayList<>();
                        for (String amountStr : materialAmountsList) {
                            amounts.add(Double.parseDouble(amountStr));
                        }
                        // If decimal number is written in a material that is bought one by one program asks the user again and again until user gives an integer for a material that is bought one by one

                        if (!(amounts.size() == sizeCodes)) {
                            System.out.println("Number of amounts don't match with number of materials");
                            System.out.println("Enter Amount of Material (Leave one space between codes): ");
                            materialAmountsStr = scanner.nextLine();
                            materialAmountsList = materialAmountsStr.split(" ");
                            amounts = new ArrayList<>();
                            for (String amountStr : materialAmountsList) {
                                amounts.add(Double.parseDouble(amountStr));
                            }
                        }
                        // Also because user can solve decimal problem but write wrong number of amounts we are checking the number in every loop

                        gamount = amounts.get(i);
                        gprice = gamount * 50;
                        gfinalweight = gweight * gamount;
                        // Redefining variables after every loop
                    }

                    priceMap.put("6 in Wheel", gprice);
                    weighMap.put("6 in Wheel", gfinalweight);
                    defaultWeighMap.put("6 in Wheel", gweight);
                    // Putting variables into the hash maps to use them in the future
                    break;

                case "2.\"4in\"":
                    double hamount = amounts.get(i);
                    double hprice = hamount * 200;
                    double hweight = 0.2;
                    double hfinalweight = hweight * hamount;
                    // Defining variables

                    while (!(hamount == Math.floor(hamount)) || !(amounts.size() == sizeCodes)) {
                        System.out.println("You can't write decimal numbers to materials that are bought with integers");
                        System.out.println("Enter Amount of Material (Leave one space between codes): ");
                        materialAmountsStr = scanner.nextLine();
                        materialAmountsList = materialAmountsStr.split(" ");
                        amounts = new ArrayList<>();
                        for (String amountStr : materialAmountsList) {
                            amounts.add(Double.parseDouble(amountStr));
                        }
                        // If decimal number is written in a material that is bought one by one program asks the user again and again until user gives an integer for a material that is bought one by one

                        if (!(amounts.size() == sizeCodes)) {
                            System.out.println("Number of amounts don't match with number of materials");
                            System.out.println("Enter Amount of Material (Leave one space between codes): ");
                            materialAmountsStr = scanner.nextLine();
                            materialAmountsList = materialAmountsStr.split(" ");
                            amounts = new ArrayList<>();
                            for (String amountStr : materialAmountsList) {
                                amounts.add(Double.parseDouble(amountStr));
                            }
                        }
                        // Also because user can solve decimal problem but write wrong number of amounts we are checking the number in every loop

                        hamount = amounts.get(i);
                        hprice = hamount * 50;
                        hfinalweight = hweight * hamount;
                        // Redefining variables after every loop
                    }

                    priceMap.put("4 in Wheel", hprice);
                    weighMap.put("4 in Wheel", hfinalweight);
                    defaultWeighMap.put("4 in Wheel", hweight);
                    // Putting variables into the hash maps to use them in the future
                    break;

                case "1/NavX":
                    double iamount = amounts.get(i);
                    double iprice = iamount * 250;
                    double iweight = 0.1;
                    double ifinalweight = iweight * iamount;
                    // Defining variables

                    while (!(iamount == Math.floor(iamount)) || !(amounts.size() == sizeCodes)) {
                        System.out.println("You can't write decimal numbers to materials that are bought with integers");
                        System.out.println("Enter Amount of Material (Leave one space between codes): ");
                        materialAmountsStr = scanner.nextLine();
                        materialAmountsList = materialAmountsStr.split(" ");
                        amounts = new ArrayList<>();
                        for (String amountStr : materialAmountsList) {
                            amounts.add(Double.parseDouble(amountStr));
                        }
                        // If decimal number is written in a material that is bought one by one program asks the user again and again until user gives an integer for a material that is bought one by one

                        if (!(amounts.size() == sizeCodes)) {
                            System.out.println("Number of amounts don't match with number of materials");
                            System.out.println("Enter Amount of Material (Leave one space between codes): ");
                            materialAmountsStr = scanner.nextLine();
                            materialAmountsList = materialAmountsStr.split(" ");
                            amounts = new ArrayList<>();
                            for (String amountStr : materialAmountsList) {
                                amounts.add(Double.parseDouble(amountStr));
                            }
                        }
                        // Also because user can solve decimal problem but write wrong number of amounts we are checking the number in every loop

                        iamount = amounts.get(i);
                        iprice = iamount * 50;
                        ifinalweight = iweight * iamount;
                        // Redefining variables after every loop
                    }

                    priceMap.put("NavX", iprice);
                    weighMap.put("NavX", ifinalweight);
                    defaultWeighMap.put("NavX", iweight);
                    // Putting variables into the hash maps to use them in the future
                    break;

                case "1/RIO":
                    double jamount = amounts.get(i);
                    double jprice = jamount * 50;
                    double jweight = 1;
                    double jfinalweight = jweight * jamount;
                    // Defining variables

                    while (!(jamount == Math.floor(jamount)) || !(amounts.size() == sizeCodes)) {
                        System.out.println("You can't write decimal numbers to materials that are bought with integers");
                        System.out.println("Enter Amount of Material (Leave one space between codes): ");
                        materialAmountsStr = scanner.nextLine();
                        materialAmountsList = materialAmountsStr.split(" ");
                        amounts = new ArrayList<>();
                        for (String amountStr : materialAmountsList) {
                            amounts.add(Double.parseDouble(amountStr));
                        }
                        // If decimal number is written in a material that is bought one by one program asks the user again and again until user gives an integer for a material that is bought one by one

                        if (!(amounts.size() == sizeCodes)) {
                            System.out.println("Number of amounts don't match with number of materials");
                            System.out.println("Enter Amount of Material (Leave one space between codes): ");
                            materialAmountsStr = scanner.nextLine();
                            materialAmountsList = materialAmountsStr.split(" ");
                            amounts = new ArrayList<>();
                            for (String amountStr : materialAmountsList) {
                                amounts.add(Double.parseDouble(amountStr));
                            }
                        }
                        // Also because user can solve decimal problem but write wrong number of amounts we are checking the number in every loop

                        jamount = amounts.get(i);
                        jprice = jamount * 50;
                        jfinalweight = jweight * jamount;
                        // Redefining variables after every loop
                    }

                    priceMap.put("RoboRIO", jprice);
                    weighMap.put("RoboRIO", jfinalweight);
                    defaultWeighMap.put("RoboRIO", jweight);
                    // Putting variables into the hash maps to use them in the future
                    break;

                case "1/Modem":
                    double kamount = amounts.get(i);
                    double kprice = kamount * 20;
                    double kweight = 0.2;
                    double kfinalweight = kweight * kamount;
                    // Defining variables

                    while (!(kamount == Math.floor(kamount)) || !(amounts.size() == sizeCodes)) {
                        System.out.println("You can't write decimal numbers to materials that are bought with integers");
                        System.out.println("Enter Amount of Material (Leave one space between codes): ");
                        materialAmountsStr = scanner.nextLine();
                        materialAmountsList = materialAmountsStr.split(" ");
                        amounts = new ArrayList<>();
                        for (String amountStr : materialAmountsList) {
                            amounts.add(Double.parseDouble(amountStr));
                        }
                        // If decimal number is written in a material that is bought one by one program asks the user again and again until user gives an integer for a material that is bought one by one

                        if (!(amounts.size() == sizeCodes)) {
                            System.out.println("Number of amounts don't match with number of materials");
                            System.out.println("Enter Amount of Material (Leave one space between codes): ");
                            materialAmountsStr = scanner.nextLine();
                            materialAmountsList = materialAmountsStr.split(" ");
                            amounts = new ArrayList<>();
                            for (String amountStr : materialAmountsList) {
                                amounts.add(Double.parseDouble(amountStr));
                            }
                        }
                        // Also because user can solve decimal problem but write wrong number of amounts we are checking the number in every loop

                        kamount = amounts.get(i);
                        kprice = kamount * 50;
                        kfinalweight = kweight * kamount;
                        // Redefining variables after every loop
                    }

                    priceMap.put("Modem", kprice);
                    weighMap.put("Modem", kfinalweight);
                    defaultWeighMap.put("Modem", kweight);
                    // Putting variables into the hash maps to use them in the future
                    break;

                case "5: CB":
                    double lamount = amounts.get(i);
                    double lprice = lamount * 80;
                    double lweight = 1.5;
                    double lfinalweight = lweight * lamount;
                    // Defining variables

                    while (!(lamount == Math.floor(lamount)) || !(amounts.size() == sizeCodes)) {
                        System.out.println("You can't write decimal numbers to materials that are bought with integers");
                        System.out.println("Enter Amount of Material (Leave one space between codes): ");
                        materialAmountsStr = scanner.nextLine();
                        materialAmountsList = materialAmountsStr.split(" ");
                        amounts = new ArrayList<>();
                        for (String amountStr : materialAmountsList) {
                            amounts.add(Double.parseDouble(amountStr));
                        }
                        // If decimal number is written in a material that is bought one by one program asks the user again and again until user gives an integer for a material that is bought one by one

                        if (!(amounts.size() == sizeCodes)) {
                            System.out.println("Number of amounts don't match with number of materials");
                            System.out.println("Enter Amount of Material (Leave one space between codes): ");
                            materialAmountsStr = scanner.nextLine();
                            materialAmountsList = materialAmountsStr.split(" ");
                            amounts = new ArrayList<>();
                            for (String amountStr : materialAmountsList) {
                                amounts.add(Double.parseDouble(amountStr));
                            }
                        }
                        // Putting variables into the hash maps to use them in the future

                        lamount = amounts.get(i);
                        lprice = lamount * 50;
                        lfinalweight = lweight * lamount;
                        // Redefining variables after every loop
                    }

                    priceMap.put("Circuit Breaker", lprice);
                    weighMap.put("Circuit Breaker", lfinalweight);
                    defaultWeighMap.put("Circuit Breaker", lweight);
                    // Putting variables into the hash maps to use them in the future
                    break;

                case "5: RSL":
                    double mamount = amounts.get(i);
                    double mprice = mamount * 2.2;
                    double mweight = 0.5;
                    double mfinalweight = mweight * mamount;
                    // Defining variables

                    while (!(mamount == Math.floor(mamount)) || !(amounts.size() == sizeCodes)) {
                        System.out.println("You can't write decimal numbers to materials that are bought with integers");
                        System.out.println("Enter Amount of Material (Leave one space between codes): ");
                        materialAmountsStr = scanner.nextLine();
                        materialAmountsList = materialAmountsStr.split(" ");
                        amounts = new ArrayList<>();
                        for (String amountStr : materialAmountsList) {
                            amounts.add(Double.parseDouble(amountStr));
                        }
                        // If decimal number is written in a material that is bought one by one program asks the user again and again until user gives an integer for a material that is bought one by one

                        if (!(amounts.size() == sizeCodes)) {
                            System.out.println("Number of amounts don't match with number of materials");
                            System.out.println("Enter Amount of Material (Leave one space between codes): ");
                            materialAmountsStr = scanner.nextLine();
                            materialAmountsList = materialAmountsStr.split(" ");
                            amounts = new ArrayList<>();
                            for (String amountStr : materialAmountsList) {
                                amounts.add(Double.parseDouble(amountStr));
                            }
                        }
                        // Putting variables into the hash maps to use them in the future

                        mamount = amounts.get(i);
                        mprice = mamount * 50;
                        mfinalweight = mweight * mamount;
                        // Redefining variables after every loop
                    }

                    priceMap.put("Robot Signal Light", mprice);
                    weighMap.put("Robot Signal Light", mfinalweight);
                    defaultWeighMap.put("Robot Signal Light", mweight);
                    // Putting variables into the hash maps to use them in the future
                    break;

                case "6.'16'":
                    double namount = amounts.get(i);
                    double nprice = namount * 0.75;
                    double nweight = 0.25;
                    double nfinalweight = nweight * namount;
                    // Defining variables

                    priceMap.put("16 AWG Wire", nprice);
                    weighMap.put("16 AWG Wire", nfinalweight);
                    defaultWeighMap.put("16 AWG Wire", nweight);
                    // Putting variables into the hash maps to use them in the future
                    break;

                case "6.'18'":
                    double oamount = amounts.get(i);
                    double oprice = oamount * 20;
                    double oweight = 0.35;
                    double ofinalweight = oweight * oamount;
                    // Defining variables

                    priceMap.put("18 AWG Wire", oprice);
                    weighMap.put("18 AWG Wire", ofinalweight);
                    defaultWeighMap.put("18 AWG Wire", oweight);
                    // Putting variables into the hash maps to use them in the future
                    break;
            }
        }
        double totalPrice = 0;
        // Defining total price

        System.out.println("Materials sorted by price (from most expensive to least expensive):");
        List<Map.Entry<String, Double>> priceEntries = new ArrayList<>(priceMap.entrySet());
        Collections.sort(priceEntries, (e1, e2) -> e2.getValue().compareTo(e1.getValue()));
        for (Map.Entry<String, Double> entry : priceEntries) {
            System.out.print(entry.getKey() + " " + amountOfDecimal.format(entry.getValue()) + ", ");
            totalPrice += entry.getValue();
        }
        // Taking the values inside the price map and compares every key's values and then sort them to be listed from most expensive to least also adding up every value to the total price to find it

        System.out.println();
        // Leaving one space

        double totalWeight = 0;
        // Defining total weight

        System.out.println("Materials sorted by weight (from least to most):");
        List<Map.Entry<String, Double>> weightEntries = new ArrayList<>(weighMap.entrySet());
        Collections.sort(weightEntries, (e1, e2) -> e1.getValue().compareTo(e2.getValue()));
        for (Map.Entry<String, Double> entry : weightEntries) {
            System.out.print(entry.getKey() + " " + amountOfDecimalWeight.format(entry.getValue()) + ", ");
            totalWeight += entry.getValue();
        }
        // Taking the values inside the weight map and compare every key's values and then sort them to be listed from lightest to heaviest also adding uo every value to the total weight to see if it passed the limit or not

        System.out.println();
        // Making one space because in the top part we used .print which resulted in printing in the same line

        if (totalWeight > weightLimit) {
            System.out.println("N -- It is over the weight limit");
        } else if (totalWeight <= weightLimit) {
            System.out.println("Y -- It is not over the weight limit");
        }
        // Checking if the total weight is over the limit or not

        System.out.println("Total Price is " + amountOfDecimal.format(totalPrice) + " Dollars");
        // Printing the total price

        if (totalWeight > weightLimit) {
            double remainedWeight = totalWeight - weightLimit;
            System.out.println("Materials to be removed to make the total weight under the limit: (EXTRA!!!)");
            List<String> remainableMaterials = findClosestMaterials(weighMap, remainedWeight);
            for (String entry : remainableMaterials) {
                System.out.print(entry + " ");
                for (Map.Entry<String, Double> weight : weighMap.entrySet()) {
                    if (weight.getKey().equals(entry)) {
                        System.out.print(amountOfDecimalWeight.format(weight.getValue()) + ", ");
                    }
                }
            }
        }
        /*
            This code first calculates the remained weight to the limit if the total weight is over the limit. Next with the help of a method that I created by
            taking parts from internet and designing them according to my needs. Then, I iterated through the list returned by the method and get the key.
            Then I looped through weighMap and take the values that are matching with the keys of the list that came from method and add the values next to them
            I wrote this method, but I guess I misunderstood because this code assumes that to reach under the limit we need to remove all the weight the material weighs.
            But, I wanted to keep it here
         */
    }
    public static List<String> findClosestMaterials(HashMap<String, Double> materials, double limit) {
        List<String> closestMaterials = new ArrayList<>();
        double closestValue = Double.MAX_VALUE;

        List<List<String>> subsets = generateSubsets(new ArrayList<>(materials.keySet()));
        // First it generates subsets over the weighMap's keys

        for (List<String> subset : subsets) {
            double total = 0.0;
            // Defining total

            for (String material : subset) {
                total += materials.get(material);
            }
            // Calculate the total weight of the current subset

            if (total >= limit && Math.abs(total - limit) < Math.abs(closestValue - limit)) {
                closestMaterials = subset;
                closestValue = total;
                // Check if the total weight is equal to or greater than the limit

                if (total == limit) {
                    break;
                }
                // If the total weight is equal to the limit, no need to check other subsets
            }
        }

        return closestMaterials;
    }

    public static List<List<String>> generateSubsets(List<String> materials) {
        List<List<String>> subsets = new ArrayList<>();
        int size = materials.size();
        for (int i = 0; i < (1 << size); i++) {
            // Using binary
            List<String> subset = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                if ((i & (1 << j)) > 0) {
                    subset.add(materials.get(j));
                }
            }
            subsets.add(subset);
        }
        return subsets;
    }
    // This code is here for creating subsets from the keys that are taken from weighMap
}
