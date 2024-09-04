import java.util.HashMap;
import java.util.Map;

public class classify {

    public static void main(String[] args) {
        String text = "このプロジェクトを共有したいです。";

        String category = classifyText(text);
        System.out.println("分類結果: " + category);
    }

    public static String classifyText(String text) {
        Map<String, String> categories = new HashMap<>();
        categories.put("質問", "質問, どうやって, なぜ, 何, いつ, どこ, 誰");
        categories.put("会話したい", "会話, 話し, 聞きたい, 相談, 話す");
        categories.put("共有", "共有, シェア, 見て, 聞いて");
        categories.put("通報", "通報, 警告, 注意, 危険");

        for (Map.Entry<String, String> entry : categories.entrySet()) {
            for (String keyword : entry.getValue().split(", ")) {
                if (text.contains(keyword)) {
                    return entry.getKey();
                }
            }
        }
        return "分類できません";
    }
}
