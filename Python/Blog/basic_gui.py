from tkinter import *

from tkinter.messagebox import *

window = Tk()



# 콤포넌트 생성 및 등록
listbox = Listbox(window)
label = Label(window, text='제목')
entry = Entry(window)
text = Text(window)
b1 = Button(window, text='생성')
b2 = Button(window, text='수정')
b3 = Button(window, text='삭제')

# 윈도우 배치 관리자 설정
listbox.grid(row=0, column=0, columnspan=3, sticky='ew')
label.grid(row=1, column=0)
entry.grid(row=1, column=1, columnspan=2, sticky='ew')
text.grid(row=2, column=0, columnspan=3)
b1.grid(row=3, column=0, sticky='ew')
b2.grid(row=3, column=1, sticky='ew')
b3.grid(row=3, column=2, sticky='ew')

# 콤포넌트 이벤트 binding

##showerror("오류", "오류가 발생했습니다.")
if askyesno("확인", "정말로 삭제하시겠습니까?"):
    print("삭제되었습니다.")
else:
    print("삭제가 취소 되었습니다.")

# 이벤트 함수 생성
window.mainloop()
