package hello.core.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
    // 위와 같은 매개변수값을 넣으면 최종 Order 결과를 반환한다.

}
