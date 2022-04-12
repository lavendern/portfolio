extends Node

const maxWeight = 50
var currentWeight = 0
var inventory = {}
signal itemAdded(item_add)
signal itemChanged(id, attr)
signal updateCurrency(currency)

func _ready():
	var file = File.new()
	file.open("res://data/player.json", file.READ)
	var text = file.get_as_text()
	var result = JSON.parse(text).result
	file.close()
	inventory = result["inventory"]
	
func addToInventory(item):
	if item.get_meta("itemType") == "Currency":
		if item.currencyType in inventory:
			inventory[item.currencyType] += item.itemCount

		else: inventory[item.currencyType] = item.itemCount
		emit_signal("updateCurrency", item.currencyType)
	else:
		if item.id in inventory:
			inventory[item.id]["itemCount"] += item.itemCount
			emit_signal("itemChanged", item.id, {"itemCount": "(x"+str(inventory[item.id]["itemCount"])+")"})
		else:
			var params = {"weight":item.weight, "value":item.value, "itemCount":item.itemCount}
			inventory[item.id] = params
			emit_signal("itemAdded", item)
		currentWeight += item.weight*item.itemCount

func getInvJSON():
	return to_json(inventory)

func getByID(id):
	if id in inventory:
		return inventory[id]
	else: return null
