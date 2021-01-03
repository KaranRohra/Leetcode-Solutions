package LeetCode;

public class ValidTic_Tac_ToeState {
    public static void main(String[] args) {
        Solution794 s=new Solution794();
        System.out.println(s.validTicTacToe(new String[]{"XOX", "O O", "XOX"}));
    }
}
class Solution794 {
    public boolean validTicTacToe(String[] board) {
        int x3Count=0,o3Count=0,xCount=0,oCount=0;
        for(int i=0;i<3;i++){
            if(board[i].equals("OOO")){
                int clash=0;
                for(int j=0;j<3;j++){
                    if(board[0].charAt(j)=='O' && board[1].charAt(j)=='O' && board[2].charAt(j)=='O'){
                        clash++;
                        break;
                    }
                }
                if(clash==0)
                    o3Count++;
            }
            else if(board[i].equals("XXX")){
                int clash=0;
                for(int j=0;j<3;j++){
                    if(board[0].charAt(j)=='X' && board[1].charAt(j)=='X' && board[2].charAt(j)=='X'){
                        clash++;
                        break;
                    }
                }
                if(clash==0)
                    x3Count++;
            }

            int verticalCheck=0;
            for(int j=0;j<3;j++){
                verticalCheck+=board[j].charAt(i);
                if(board[i].charAt(j)=='X')
                    xCount++;
                else if(board[i].charAt(j)=='O')
                    oCount++;
            }

            if(verticalCheck=='O'*3)
                o3Count++;
            else if(verticalCheck=='X'*3)
                x3Count++;
        }

        if(x3Count>1 || o3Count>1 || (x3Count>=1 && o3Count>=1) || xCount-oCount>1 || oCount>xCount)
            return false;

        if(board[0].charAt(0)=='X' && board[1].charAt(1)=='X' && board[2].charAt(2)=='X')
            x3Count++;
        else if(board[2].charAt(0)=='X' && board[1].charAt(1)=='X' && board[0].charAt(2)=='X')
            x3Count++;

        if(board[0].charAt(0)=='O' && board[1].charAt(1)=='O' && board[2].charAt(2)=='O')
            o3Count++;
        else if(board[2].charAt(0)=='O' && board[1].charAt(1)=='O' && board[0].charAt(2)=='O')
            o3Count++;

        if(x3Count==1 && xCount<=oCount)
            return false;
        else if(o3Count==1 && oCount!=xCount)
            return false;

        return true;
    }
}
