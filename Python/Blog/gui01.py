from tkinter import *

# 윈도우 생성
window = Tk()
# JFrame win = new JFrame();
label = Label(window, text='Hello World')
label1 = Label(window, text='Hello World1')

label1.pack()
label.pack()

window.mainloop()