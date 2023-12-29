from tkinter import *

# 윈도우 생성
window = Tk()

b1 = Button(window, text='저장' )
b1.pack()

def btn_click(event):
    print("버튼 클릭!!")

b1.bind('<Button-2>', btn_click)

window.mainloop()