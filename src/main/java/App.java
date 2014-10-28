import com.thoughtworks.iamcoach.pos.*;

import java.util.List;

public class App {
    public static void main(String[] args) {
        try {
            List list = FileHelper.get("cart.txt");
            Scanner scanner = new BarcodeScanner();
            PromotionHelper promotionHelper = new PromotionHelper();
            Pos pos = new Pos(scanner,promotionHelper);
            pos.printInventory(list);

        } catch (Exception e) {
            System.out.println("对不起本机暂停服务。。。。。。。。。。");
        }
    }
}
