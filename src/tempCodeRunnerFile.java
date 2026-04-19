static Node Question2(Node head){
        Node temp=head;
        while(temp!=null ){
            if(temp.data.equals("1")){
                Node el=temp.next;
                int count=0;
                while(el!=null && el.data.equals("A")){
                    count++;
                    el=el.next;
                }temp.data=Integer.toString(count);
                temp.next=el;
            }temp=temp.next;
        }
        return head;
    }