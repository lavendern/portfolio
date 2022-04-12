extends RayCast

var tooltipShow = false
onready var ply = get_parent().get_parent().get_parent()
onready var HUD = ply.get_node("HUD")
onready var toolTip = ply.get_node("HUD/ToolTip")
#var wait = Timer.new()

func _physics_process(delta):
	if(is_colliding()):
		if get_collider().get_parent().has_meta("interactable"):
			var ent = get_collider().get_parent()
			toolTip.set_text(ent.entityName)
			tooltipShow=true
			if ent is Item:
				toolTip.set_text(ent.entityName+"(x"+str(ent.itemCount)+")")
				toolTip.get_node("subTip").text = "(e) pick up"
			else:
				toolTip.get_node("subTip").text = "(e) interact"
			
			toolTip.get_node("subTip").show()
			
			if Input.is_action_just_pressed("interact"):
				ent.interact(ply)
				tooltipShow = false
		else:
			tooltipShow=false
	else:
		tooltipShow = false
	interactUI()

func interactUI():
	if(tooltipShow && !toolTip.visible):
		toolTip.show()
		HUD.change_cursor(HUD.cursor_hand)
	elif(!tooltipShow && toolTip.visible):
		toolTip.hide()
		HUD.change_cursor(HUD.cursor_def)
