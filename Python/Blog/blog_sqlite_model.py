import sqlite3
import time

def add_blog(subject, content):
    conn = sqlite3.connect('blog.db')
    conn.row_factory = sqlite3.Row
    c = conn.cursor()
    today = time.strftime('%Y%m%d')
    c.execute("INSERT INTO blog (subject, content, date) VALUES (?, ?, ?)", 
        (subject, content, today))
    conn.commit()
    conn.close()

def get_blog_list():
    conn = sqlite3.connect('blog.db')
    conn.row_factory = sqlite3.Row
    cursor = conn.cursor()
    cursor.execute('SELECT * FROM blog')
    result_set = cursor.fetchall()
    conn.close()
    return result_set

def read_blog(_id):
    conn = sqlite3.connect('blog.db')    
    conn.row_factory = sqlite3.Row
    cursor = conn.cursor()
    cursor.execute("SELECT * FROM blog WHERE id= ?", (_id,))
    result = cursor.fetchone()
    conn.close()
    return result

def modify_blog(_id, subject, content):
    conn = sqlite3.connect('blog.db')
    conn.row_factory = sqlite3.Row
    c = conn.cursor()
    c.execute("UPDATE blog SET subject=?, content=? WHERE id=?", 
        (subject, content, _id))
    conn.commit()
    conn.close()

def remove_blog(_id):
    conn = sqlite3.connect('blog.db')
    conn.row_factory = sqlite3.Row
    c = conn.cursor()
    c.execute("DELETE FROM blog WHERE id=?", (_id,))
    conn.commit()
    conn.close()


