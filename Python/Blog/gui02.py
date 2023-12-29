from tkinter import *

# 윈도우 생성
window = Tk()
# JFrame win = new JFrame();
label = Label(window, text='Hello World')
listbox = Listbox(window)
label.pack()
listbox.pack()

for i in ['one', 'two', 'three', 'four']:
    listbox.insert(END,i)


def event_for_listbox(event):
    print("Hello event")

listbox.bind('<<ListboxSelect>>', event_for_listbox)


window.mainloop()
