extends Spatial

class_name Item

var value:int
var weight:int
export var id:int
export var itemCount:int
var entityName:String
var desc:String
var currencyType:String

func _ready()->void:
	set_meta("interactable", "item")
	
	var file = File.new()
	file.open("res://data/items.json", file.READ)
	var text = file.get_as_text()
	var result = JSON.parse(text).result
	file.close()
	entityName = result[id]["name"]
	desc = result[id]["desc"]
	weight = result[id]["weight"]
	value = result[id]["value"]
	set_meta("itemType", result[id]["itemType"])
	if(result[id]["itemType"]=="Currency"):
		currencyType = result[id].currencyType

func interact(ply)->void:
	ply.get_node("plyInv").addToInventory(self)
	queue_free()
