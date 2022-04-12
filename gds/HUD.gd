extends Control
class_name HUD

onready var cursor_def = load("res://img/ui/cursor-def.png")
onready var cursor_hand = load("res://img/ui/cursor-hand.png")
onready var cursor_chat = load("res://img/ui/cursor-chat.png")
var inMenu = null

# Called when the node enters the scene tree for the first time.
func _ready():
	$Pause.visible = false;



func _input(event):
	if Input.is_action_just_pressed("ui_cancel"):
		if !inMenu:
			toggleMenu("Pause")
		else:
			toggleMenu(inMenu)
	if Input.is_action_just_pressed("inventory"):
		toggleMenu("Inventory")

func _on_Quit_pressed():
	get_tree().quit()

func _invButton():
	toggleMenu("Inventory")

func _on_Resume_pressed():
	toggleMenu("Pause")

func change_cursor(cursor):
	$Crosshair.texture = cursor

func toggleMenu(menu):
	var item = get_node(menu)
	print (item.name)
	if(item.visible):
		item.hide()
		if inMenu == menu:
			Input.set_mouse_mode(Input.MOUSE_MODE_CAPTURED)
			get_tree().paused=false
			inMenu = null
			
		else:
			inMenu = str(get_path_to(item.parent()))
	else:
		item.show()
		if !inMenu:
			get_tree().paused=true
			Input.set_mouse_mode(Input.MOUSE_MODE_VISIBLE)
		elif get_node(inMenu).visible:
			get_node(inMenu).hide()
		inMenu = str(get_path_to(item))
		
