class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m=len(matrix)
        n=len(matrix[0])

        i=0
        j=m-1
        row=-1
        while i<=j:
            mid=(i+j)//2
            if matrix[mid][0]<=target<=matrix[mid][n-1]:
                row=mid
                break
            elif matrix[mid][0]>target:
                j=mid-1
            else:
                i=mid+1
        if row==-1:
            return False
        a=0
        b=n-1

        while a<=b:
            midd=(a+b)//2
            if matrix[row][midd]==target:
                return True
            elif matrix[row][midd]>target:
                b=midd-1
            else:
                a=midd+1
        return False