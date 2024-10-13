public class MyList {
    ListNode head = new ListNode();

    void add(int x)
    {
        ListNode newNode = new ListNode(x);
        if(head.next == null)
        {
            head.next = newNode;
        }else
        {
            ListNode p = head;
            while(p.next != null)
            {
                p = p.next;
            }

        }
    }

    void print()
    {
        ListNode p = head;
        while(p != null)
        {
            System.out.print(p.key + " ");
            p = p.next;
        }
        system.out.println();
    }

    int indexOf(int x)
    {
        ListNode p = head;
        int cnt = 0;
        while(p != null)
        {
            if(p.key == x){return cnt;}
            cnt++;
            p = p.next;
        }

        return -1;
    }

    int get(int n)
    {
        ListNode p = head;
        int cnt = 0;
        while(p != null)
        {
            if(cnt == n){return p.key;}
            cnt++;
            p = p.next;
        }

        throw new IndexOutOfBoundsException();
        
    }
}
