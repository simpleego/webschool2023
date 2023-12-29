from tkinter import *

# 윈도우 생성
window = Tk()

entry = Entry(window)
text = Text(window)
entry.pack()

data = '''
    인생은 짧고
    예술은 길다...
'''
text.insert(1.4, data)
text.insert(5.14, '*****************')

text.pack()

entry.insert(0, "Hello python")

input = entry.get()
print(input)


window.mainloop()
