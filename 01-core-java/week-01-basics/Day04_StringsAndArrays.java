// package week_01_basics;

public class Day04_StringsAndArrays {
    public static void main(String[] args) {

        System.out.println("==========================================");
        System.out.println("  BACKEND AUDIT LOG & JSON REPORT ENGINE  ");
        System.out.println("==========================================");

        // 1. Array of API endpoints accessed today (including the new search endpoint)
        String[] accessedEndpoints = {
                "/api/v1/auth/login",
                "/api/v1/users/profile",
                "/api/v1/orders/checkout",
                "/api/v1/payments/process",
                "/api/v1/auth/logout",
                "/api/v1/products/search"
        };

        // 2. Useful Array Properties
        System.out.println("Total Endpoints Tracked: " + accessedEndpoints.length);
        System.out.println("First Endpoint Accessed: " + accessedEndpoints[0]);
        System.out.println("Last Endpoint Accessed : " + accessedEndpoints[accessedEndpoints.length - 1]);
        System.out.println("------------------------------------------");

        // 3. String Methods in Action
        String sampleApi = "   /API/V1/USERS/PROFILE   ";
        System.out.println("Raw Input       : '" + sampleApi + "'");
        System.out.println("Trimmed         : '" + sampleApi.trim() + "'");
        System.out.println("Lowercase       : '" + sampleApi.trim().toLowerCase() + "'");
        System.out.println("Contains 'USERS': " + sampleApi.contains("USERS"));
        System.out.println("------------------------------------------");

        // 4. High-Performance JSON Payload Construction using StringBuilder
        StringBuilder jsonBuilder = new StringBuilder();

        jsonBuilder.append("{\n");
        jsonBuilder.append("  \"service\": \"Auth-Audit-Service\",\n");
        jsonBuilder.append("  \"status\": \"SUCCESS\",\n");
        jsonBuilder.append("  \"totalLogs\": ").append(accessedEndpoints.length).append(",\n");
        jsonBuilder.append("  \"endpoints\": [\n");

        // Loop through array and build JSON array dynamically
        for (int i = 0; i < accessedEndpoints.length; i++) {
            jsonBuilder.append("    \"").append(accessedEndpoints[i]).append("\"");

            // Add comma after every item EXCEPT the last one
            if (i < accessedEndpoints.length - 1) {
                jsonBuilder.append(",");
            }
            jsonBuilder.append("\n");
        }

        jsonBuilder.append("  ]\n");
        jsonBuilder.append("}");

        // Convert the StringBuilder buffer to a final String
        String jsonPayload = jsonBuilder.toString();

        System.out.println("GENERATED JSON AUDIT PAYLOAD:");
        System.out.println(jsonPayload);
        System.out.println("==========================================");
    }
}