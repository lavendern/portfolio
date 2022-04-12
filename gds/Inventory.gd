extends TextureRect

onready var plyInv = get_parent().get_parent().get_node("plyInv")
onready var item = preload("res://obj/ui/invItem.tscn")
var items = []

func _ready():
	plyInv.connect("itemAdded", self, "_itemAdded")
	plyInv.connect("itemChanged", self, "_itemChanged")
	plyInv.connect("updateCurrency", self, "_updateCurrency")
	for item in plyInv.inventory:
		if item.has("id"):
			addItem(item)
		elif item.has("currencyType"):
			_updateCurrency(item.currencyType)


func addItem(inv_item):
		items.append(item.instance())
		items[-1].id = inv_item.id
		if inv_item.itemCount < 2:
			items[-1].get_node("HBoxContainer/itemCount").text=""
		else:
			items[-1].get_node("HBoxContainer/itemCount").text=str(inv_item.itemCount)
		items[-1].get_node("HBoxContainer/ItemName").text=str(inv_item.entityName)
		items[-1].get_node("HBoxContainer/weight").text=str(inv_item.weight)
		items[-1].get_node("HBoxContainer/value").text=str(inv_item.value)
		$Items/List.add_child(items[-1], true)

func _itemAdded(inv_item):
		addItem(inv_item)

func _itemChanged(id, attr):
	var ui=getItemUI(id)
	ui.get_node("HBoxContainer/"+attr.keys()[0]).text=str(attr.values()[0])

func _updateCurrency(currency):
	$Currencies.get_node(currency).text = str(plyInv.inventory[currency])

func getItemUI(id):
	if items.size()>0:
		for i in items:
			if id==i.id:
				return i
	return null
