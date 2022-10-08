package guru.qa.bankingDetails;

import java.util.ArrayList;

public class BankingDetails {
        public String uid;
        public int accID;
        public String accType;
        public String accNum;
        public int clientType;
        public ArrayList<Content> info;
        public boolean residence;
        public static class Content {
            public int accID;
            public String accNum;
            public int clientType;
        }
    }

