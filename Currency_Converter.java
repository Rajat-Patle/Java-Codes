import java.util.*;
class Currency {
    Scanner sc = new Scanner(System.in);

    void menu() {
        System.out.println("\n!===== Currency Convertor Menu =====!");
        System.out.println("\n1.Rupees\n2.Dollar\n3.Pound\n4.Euro\n5.Kuwaiti Dinar");
        System.out.print("\nWhich Currency do you want to Convert (1 to 5) :- ");
        int choice1 = sc.nextInt();

        switch (choice1) {
            case 1:
                System.out.println("\n!===== Convert To =====!");
                System.out.println("\n1.Dollar\n2.Pound\n3.Euro\n4.Kuwaiti Dinar");
                System.out.print("\nWhich Currency do you want to Convert into (1 to 4) :- ");
                int choice2 = sc.nextInt(); {
                System.out.print("\nEnter the Amount in Rupees (₹) :- ");
                long INR = sc.nextLong();
                switch (choice2) {
                    case 1:
                        double usd = INR / 83.14;
                        System.out.println("\n!..... ₹" + INR + " (Rupees) = $" + usd + " (DOLLARS) .....!\n\n");
                        break;
                    case 2:
                        double pounds = INR * 0.0095;
                        System.out.println("\n!..... ₹" + INR + " (Rupees) = £" + pounds + " (POUNDS) .....!\n\n");
                        break;
                    case 3:
                        double euro = INR * 0.011;
                        System.out.println("\n!..... ₹" + INR + " (Rupees) = €" + euro + " (EUROS) .....!\n\n");
                        break;
                    case 4:
                        double dinar = INR / 0.0037;
                        System.out.println("\n!..... ₹" + INR + " (Rupees) = KWD" + dinar + " (Kuwaiti Dinar) .....!\n\n");
                        break;
                    default:
                        System.out.println("\n!!!___ Invalid Choice ___!!!\n\n");
                        break;
                }
            }
                break;
            case 2:
                System.out.println("\n!===== Convert To =====!");
                System.out.println("\n1.Rupees\n2.Pound\n3.Euro\n4.Kuwaiti Dinar");
                System.out.print("\nWhich Currency do you want to Convert into (1 to 4) :- ");
                int choice3 = sc.nextInt();
                System.out.print("\nEnter the Amount in USD :- ");
                double usd2 = sc.nextDouble(); {
                switch (choice3) {
                    case 1:
                        double inr = usd2 * 83.14;
                        System.out.println("\n!..... $" + usd2 + " (DOLLARS) = ₹" + inr + " (Rupees) .....!\n\n");
                        break;
                    case 2:
                        double pounds2 = usd2 * 0.79;
                        System.out.println("\n!..... $" + usd2 + " (DOLLARS) = £" + pounds2 + " (POUNDS) .....!\n\n");
                        break;
                    case 3:
                        double euro2 = usd2 * 0.92;
                        System.out.println("\n!..... $" + usd2 + " (DOLLARS) = €" + euro2 + " (EUROS) .....!\n\n");

                        break;
                    case 4:
                        double dinar2 = usd2 * 0.31;
                        System.out.println("\n!..... $" + usd2 + " (DOLLARS) = KWD" + dinar2 + " (KUWAITI DINAR) .....!\n\n");
                        break;

                    default:
                        System.out.println("\n!!!___ Invalid Choice ___!!!\n\n");
                        break;
                }
            }
                break;
            case 3:
                System.out.println("\n!===== Convert To =====!");
                System.out.println("\n1.Rupees\n2.Dollar\n3.Euro\n4.Kuwaiti Dinar");
                System.out.print("\nWhich Currency do you want to Convert into (1 to 4) :- ");
                int choice4 = sc.nextInt();
                System.out.print("\nEnter the Amount in POUNDS (£) :- ");
                double pounds3 = sc.nextDouble(); {
                switch (choice4) {
                    case 1:
                        double inr3 = pounds3 * 105.73;
                        System.out.println("\n!..... £" + pounds3 + " (POUNDS) = ₹" + inr3 + " (Rupees) .....!\n\n");
                        break;
                    case 2:
                        double usd3 = pounds3 * 1.27;
                        System.out.println("\n!..... £" + pounds3 + " (POUNDS) = $" + usd3 + " (DOLLARS) .....!\n\n");
                        break;
                    case 3:
                        double euro3 = pounds3 * 1.17;
                        System.out.println("\n!..... £" + pounds3 + " (POUNDS) = €" + euro3 + " (EUROS) .....!\n\n");
                        break;
                    case 4:
                        double dinar3 = pounds3 * 0.39;
                        System.out.println("\n!..... £" + pounds3 + " (POUNDS) = KWD" + dinar3 + " (KUWAITI DINAR) .....!\n\n");
                        break;

                    default:
                        System.out.println("\n!!!___ Invalid Choice ___!!!\n\n");
                        break;
                }
            }
                break;
            case 4:
                System.out.println("\n!===== Convert To =====!");
                System.out.println("\n1.Rupees\n2.Dollar\n3.Euro\n4.Kuwaiti Dinar");
                System.out.print("\nWhich Currency do you want to Convert into (1 to 4) :- ");
                int choice5 = sc.nextInt();
                System.out.print("\nEnter the Amount in EUROS :- ");
                double euro4 = sc.nextDouble(); {
                switch (choice5) {
                    case 1:
                        double inr4 = euro4 * 90.25;
                        System.out.println("\n!..... €" + euro4 + " (EUROS) = ₹" + inr4 + " (Rupees) .....!\n\n");
                        break;
                    case 2:
                        double usd4 = euro4 * 1.09;
                        System.out.println("\n!..... €" + euro4 + " (EUROS) = $" + usd4 + " (DOLLARS) .....!\n\n");
                        break;
                    case 3:
                        double pounds4 = euro4 * 0.85;
                        System.out.println("\n!..... €" + euro4 + " (EUROS) = £" + pounds4 + " (POUNDS) .....!\n\n");
                        break;
                    case 4:
                        double dinar4 = euro4 * 0.33;
                        System.out.println("\n!..... €" + euro4 + " (EUROS) = KWD" + dinar4 + " (KUWAITI DINAR) .....!\n\n");
                        break;

                    default:
                        System.out.println("\n!!!___ Invalid Choice ___!!!\n\n");
                        break;
                }
            }
                break;
            case 5:
                System.out.println("\n!===== Convert To =====!");
                System.out.println("\n1.Rupees\n2.Dollar\n3.Pound\n4.Euro");
                System.out.print("\nWhich Currency do you want to Convert into (1 to 5) :- ");
                int choice6 = sc.nextInt();
                System.out.print("\nEnter the Amount in KUWAITI DINAR :- ");
                double dinar5 = sc.nextDouble(); {
                switch (choice6) {
                    case 1:
                        double inr5 = dinar5 * 270.23;
                        System.out.println("\n!..... KWD" + dinar5 + " (KUWAITI DINAR) = ₹" + inr5 + " (RUPEES) .....!\n\n");
                        break;
                    case 2:
                        double usd5 = dinar5 * 3.25;
                        System.out.println("\n!..... KWD" + dinar5 + " (KUWAITI DINAR) = $" + usd5 + " (DOLLARS) .....!\n\n");
                        break;
                    case 3:
                        double pounds5 = dinar5 * 2.55;
                        System.out.println("\n!..... KWD" + dinar5 + " (KUWAITI DINAR) = £" + pounds5 + " (POUNDS) .....!\n\n");
                        break;
                    case 4:
                        double euro5 = dinar5 * 2.99;
                        System.out.println("\n!..... KWD" + dinar5 + " (KUWAITI DINAR) = €" + euro5 + " (EUROS) .....!\n\n");
                        break;

                    default:
                        System.out.println("\n!!!___ Invalid Choice ___!!!\n\n");
                        break;
                }
            }
                break;

            default:
                System.out.println("\n!!!___ Invalid Choice ___!!!\n\n");
                break;
        }
    }
}

public class Currency_Converter {
    public static void main(String[] args) {
        Currency cobj = new Currency();
        cobj.menu();
    }

}